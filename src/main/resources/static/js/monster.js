Core = {

    startup: function() {

                //init widgets
                $( "#monsterTypes" ).controlgroup()
                $( "#crselect" ).selectmenu();
                $( "#namecompareselect" ).selectmenu();
                $( "#crcompareselect" ).selectmenu();
                $( "#monstername" ).autocomplete();
                $( "#tabs" ).tabs();

                //disable comparison selectors initially until assoc widget used
                $( "#namecompareselect" ).selectmenu("disable");
                $( "#crcompareselect" ).selectmenu("disable");

                //bind callbacks on control change
                this.bindMonsterNameChange();
                this.bindMonsterCrChange();

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

    getName: function(){
        var name = $('#monstername').val();
        var nameCompare = $('#namecompareselect').val();

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
        monsterCr = null;
    }
    return monsterCr;
 },

 getCrComparison: function() {
  var monsterCrCompare = $('#crcompareselect').val();
  if($('#crcompareselect'))
  return monsterCrCompare;
 },

 getMonsterTypes: function() {
    var selectedTypes = [];
    $('input,[type="checkbox"]').each(function () {
        if (this.checked) {
            selectedTypes.push(this.name);
        }

    });
    return selectedTypes;
 },


 onSubmit: function(){
    var monsterSearch = new MonsterSearch();
    monsterSearch.name = this.getName();
    monsterSearch.cr = this.getCr();
    monsterSearch.crComparison = this.getCrComparison();
    monsterSearch.selectedTypes = this.getMonsterTypes();
    alert("monster name: " + monsterSearch.name+ " monster cr: " + monsterSearch.cr + " cr comparison: " + monsterSearch.crComparison+ " monster types: " + monsterSearch.selectedTypes);

 }

}

function MonsterSearch() {
this.name="";
this.cr=0;
this.crComparison="";
this.selectedTypes=[];
}