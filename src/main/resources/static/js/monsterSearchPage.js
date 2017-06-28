SearchPage = {

    startup: function() {

                //init widgets
                $( "#monsterTypes" ).controlgroup();
                $( "#crselect" ).selectmenu();
                $( "#namecompareselect" ).selectmenu();
                $( "#crcompareselect" ).selectmenu();

                $( "#tabs" ).tabs();


                //disable comparison selectors initially until assoc widget used
                $( "#namecompareselect" ).selectmenu("disable");
                $( "#crcompareselect" ).selectmenu("disable");

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

 getCr: function() {
    var monsterCr = $('#crselect').val();
    if(monsterCr == 'any'){
        monsterCr = -1;
    }
    return monsterCr;
 },

 getCrComparison: function() {
  var monsterCrCompare = $('#crcompareselect').val();
  if($('#crselect').val()=="any"){
  monsterCrCompare = null;
  }
  return monsterCrCompare;
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
    var cr_val = this.getCr();
    var crComparison_val = this.getCrComparison();
    var type_val = this.getMonsterTypes();

    var toSend = {name:name_val,cr:cr_val,crComparison:crComparison_val,type:type_val};
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