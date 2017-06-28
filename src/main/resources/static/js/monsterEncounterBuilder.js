EncounterBuilderCore = {

    startup: function() {

        $( "#monsterTypesEncounter" ).controlgroup();
        $( "#partyLevel" ).selectmenu();
        $( "#partySize" ).selectmenu();

        this.bindEncounterSubmit();

    },

    getMonsterTypesEncounter: function() {
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

     getPartySize: function() {
         var partySize = $('#partySize').val();
         return partySize;
      },

     getPartyLevel: function() {
           var partyLevel = $('#partyLevel').val();
           return partyLevel;
        },


    bindEncounterSubmit: function() {
            $('#encounterSubmit').click(function() {
                EncounterBuilderCore.onSubmit();
            });

    },

    onSubmit: function() {


        var type_val = this.getMonsterTypesEncounter();
        var partySize = this.getPartySize();
        var partyLevel = this.getPartyLevel();
        var toSendEncounter = {type:type_val,partySize:partySize,partyLevel:partyLevel};
        
        console.log(JSON.stringify(toSendEncounter));
    }
}
