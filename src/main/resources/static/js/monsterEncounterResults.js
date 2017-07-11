EncounterSearchResults = {

    table: {},
    xpTableFinal: {},


    startup: function() {


        this.table = $('#encounterSearchResultsMonsterTableHolder').DataTable( {
            columns: [
                { data: 'name' },
                { data: 'cr'},
                { data: 'xpValue'},
                { data: 'pageNumber'},
                { data: 'type'}
            ]
        } );

        this.xpTableFinal = $('#encounterSearchResultsXpTableHolder').DataTable( {
                    "order": [[ 2, "desc" ]]
                } );
    },

    buildPage: function(data) {

        console.log(JSON.stringify(data));

        var monsterList = data.encounterMonsterList

        var xpList = data.xpTable;

        this.table.clear().rows.add(monsterList).draw();
        this.xpTableFinal.clear();

        for(i = 1; i <= 6;i++){


        intermediateTable = [];
        xpTableFinal = [];



        switch(i){

        case 1:

            intermediateTable.push("1 monster");

            for (j = 1; j <=4;j++){
                intermediateTable[j] = xpList[0][j-1]
            }

            xpTableFinal.push(intermediateTable);
            console.log(intermediateTable);
            this.xpTableFinal.rows.add(xpTableFinal).draw();
            break;


        case 2:

            intermediateTable.push("2 monsters");

            for (j = 1; j <=4;j++){
                intermediateTable[j] = xpList[1][j-1]
            }

            xpTableFinal.push(intermediateTable);
            console.log(intermediateTable);
            this.xpTableFinal.rows.add(xpTableFinal).draw();
            break;

        case 3:

            intermediateTable.push("3-6 monsters");

            for (j = 1; j <=4;j++){
                intermediateTable[j] = xpList[2][j-1]
            }

            xpTableFinal.push(intermediateTable);
            console.log(intermediateTable);
            this.xpTableFinal.rows.add(xpTableFinal).draw();
            break;

        case 4:

            intermediateTable.push("7-10 monsters");

            for (j = 1; j <=4;j++){
                intermediateTable[j] = xpList[3][j-1]
            }
            xpTableFinal.push(intermediateTable);
            console.log(intermediateTable);
            this.xpTableFinal.rows.add(xpTableFinal).draw();
            break;

        case 5:

            intermediateTable.push("11-14 monsters");

            for (j = 1; j <=4;j++){
                intermediateTable[j] = xpList[4][j-1]
            }
            xpTableFinal.push(intermediateTable);
            console.log(intermediateTable);
            this.xpTableFinal.rows.add(xpTableFinal).draw();
            break;

        case 6:

        intermediateTable.push("15+ monsters");

        for (j = 1; j <=4;j++){
            intermediateTable[j] = xpList[5][j-1]
        }

        xpTableFinal.push(intermediateTable);
        console.log(intermediateTable);
        this.xpTableFinal.rows.add(xpTableFinal).draw();
        break;
    }


   }

//   this.xpTableFinal.clear().rows.add(xpList).draw();
}
}