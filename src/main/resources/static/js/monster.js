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

    onSubmit: function(){

        var name = $('#monstername').val();
        var crcompareselect = $('#crcompareselect').val();

        var nameSearch = $('#namecompareselect').val()
        switch(nameSearch) {

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

        alert('Name: ' + name + 'CrThing: ' + crcompareselect);
    }
}