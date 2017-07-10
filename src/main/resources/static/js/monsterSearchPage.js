SearchPage = {

    startup: function() {

                //init widgets
                $( "#monsterTypes" ).controlgroup();
                $( "#minCrSelect" ).selectmenu();
                $( "#maxCrSelect" ).selectmenu();
                $( "#namecompareselect" ).selectmenu();


                $( "#tabs" ).tabs();


                //disable comparison selectors initially until assoc widget used
                $( "#namecompareselect" ).selectmenu("disable");


                //bind callbacks on control change
                this.bindMonsterNameChange();
                this.bindMonsterCrChange();
                this.bindMonsterSearchSubmit();


    },

    bindMonsterNameChange: function() {

       $( "#monstername" ).autocomplete({
          change: function( event, ui ) {
            var text = $( "#monstername" ).val();
            if(text.length == 0){
                $( "#namecompareselect" ).selectmenu("disable");
            }
            else{
                $( "#namecompareselect" ).selectmenu("enable");
            }
          }
        });
    },

    bindMonsterCrChange: function() {

           $( "#crselect" ).selectmenu({
              change: function( event, ui ) {
                var value = $( "#crselect" ).val();
                if(value == "any"){
                    $( "#crcompareselect" ).selectmenu("disable");
                }
                else{
                    $( "#crcompareselect" ).selectmenu("enable");
                }
              }
            });
        },

    bindMonsterSearchSubmit: function() {

        $("#searchSubmit").click(function() {
            SearchPage.onSubmit();
        });

    },

    getName: function() {

        var name = $('#monstername').val();
        var nameCompare = $('#namecompareselect').val();

        if(name.trim().length==0){
            name=null;
            nameCompare=null;
            return name;
        }

        switch(nameCompare) {

            case "starts with":
                name = name + "*";
                break;

            case "ends with":
                name = "*" + name;
                break;

            case "contains":
                name = "*" + name + "*";
                break;
         }

    return name;
 },

 getMinCr: function() {
    var minMonsterCr = $('#minCrSelect').val();
    if(minMonsterCr == 'any'){
        minMonsterCr = null;
    }
    return minMonsterCr;
 },

 getMaxCr: function() {
     var maxMonsterCr = $('#maxCrSelect').val();
     if(maxMonsterCr == 'any'){
         maxMonsterCr = null;
     }
     return maxMonsterCr;
  },


 getMonsterTypes: function() {
    var type = "";
    $('input,[type="checkbox"]').each(function () {
        if (this.checked) {
            type = type + this.name.toUpperCase()+" ";
        }

        if(type.trim().length==0){
            return null;
        }

    });
    return type;
 },


 onSubmit: function() {

    var name_val = this.getName();
    var minCr_val = this.getMinCr();
    var maxCr_val = this.getMaxCr();
    var type_val = this.getMonsterTypes();

    console.log('this host is: ' + window.location.href);

    var toSend = {name:name_val,minCr:minCr_val,maxCr:maxCr_val,type:type_val};
    console.log(toSend);
    console.log('is PlainObject: ' + $.isPlainObject(toSend));
    $("#tabs").tabs({
      active: 1
    });
    $.post("http://localhost:8080/monsters",toSend,function(data, status, jqXHR) {
        SearchResults.buildPage(data);
        console.log("search results data passed");
    });
 }

}