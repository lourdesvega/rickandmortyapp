package lourdes.vega.rickandmorty.getCharacters.remote


val validCharacterResponse = """
    {
       "info":{
          "count":826,
          "pages":42,
          "next":"https://rickandmortyapi.com/api/character/?page=21",
          "prev":"https://rickandmortyapi.com/api/character/?page=19"
       },
       "results":[
          {
             "id":381,
             "name":"Woman Rick",
             "status":"Alive",
             "species":"Alien",
             "type":"Chair",
             "gender":"Female",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"unknown",
                "url":""
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/381.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/10"
             ],
             "url":"https://rickandmortyapi.com/api/character/381",
             "created":"2018-01-10T19:46:00.622Z"
          },
          {
             "id":382,
             "name":"Worldender",
             "status":"Dead",
             "species":"Alien",
             "type":"",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"Worldender's lair",
                "url":"https://rickandmortyapi.com/api/location/4"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/382.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/25"
             ],
             "url":"https://rickandmortyapi.com/api/character/382",
             "created":"2018-01-10T19:47:55.859Z"
          },
          {
             "id":383,
             "name":"Yaarb",
             "status":"Alive",
             "species":"Alien",
             "type":"",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"St. Gloopy Noops Hospital",
                "url":"https://rickandmortyapi.com/api/location/16"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/383.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/19"
             ],
             "url":"https://rickandmortyapi.com/api/character/383",
             "created":"2018-01-10T19:48:59.952Z"
          },
          {
             "id":384,
             "name":"Yellow Headed Doctor",
             "status":"Alive",
             "species":"Alien",
             "type":"",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"St. Gloopy Noops Hospital",
                "url":"https://rickandmortyapi.com/api/location/16"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/384.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/19"
             ],
             "url":"https://rickandmortyapi.com/api/character/384",
             "created":"2018-01-10T19:50:19.351Z"
          },
          {
             "id":385,
             "name":"Yellow Shirt Rick",
             "status":"unknown",
             "species":"Human",
             "type":"",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"Citadel of Ricks",
                "url":"https://rickandmortyapi.com/api/location/3"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/385.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/22"
             ],
             "url":"https://rickandmortyapi.com/api/character/385",
             "created":"2018-01-10T19:51:18.996Z"
          },
          {
             "id":386,
             "name":"Zarbadar Gloonch",
             "status":"Dead",
             "species":"Alien",
             "type":"Drumbloxian",
             "gender":"Female",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"Nuptia 4",
                "url":"https://rickandmortyapi.com/api/location/13"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/386.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/13",
                "https://rickandmortyapi.com/api/episode/18"
             ],
             "url":"https://rickandmortyapi.com/api/character/386",
             "created":"2018-01-10T19:52:40.898Z"
          },
          {
             "id":387,
             "name":"Zarbadar's Mytholog",
             "status":"unknown",
             "species":"Mythological Creature",
             "type":"Mytholog",
             "gender":"Female",
             "origin":{
                "name":"Nuptia 4",
                "url":"https://rickandmortyapi.com/api/location/13"
             },
             "location":{
                "name":"Nuptia 4",
                "url":"https://rickandmortyapi.com/api/location/13"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/387.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/18"
             ],
             "url":"https://rickandmortyapi.com/api/character/387",
             "created":"2018-01-10T19:54:17.951Z"
          },
          {
             "id":388,
             "name":"Zeep Xanflorp",
             "status":"Alive",
             "species":"Humanoid",
             "type":"Microverse inhabitant",
             "gender":"Male",
             "origin":{
                "name":"Rick's Battery Microverse",
                "url":"https://rickandmortyapi.com/api/location/24"
             },
             "location":{
                "name":"Rick's Battery Microverse",
                "url":"https://rickandmortyapi.com/api/location/24"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/388.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/17"
             ],
             "url":"https://rickandmortyapi.com/api/character/388",
             "created":"2018-01-10T19:56:57.790Z"
          },
          {
             "id":389,
             "name":"Zeta Alpha Rick",
             "status":"Dead",
             "species":"Human",
             "type":"",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"Rick's Memories",
                "url":"https://rickandmortyapi.com/api/location/126"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/389.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/10",
                "https://rickandmortyapi.com/api/episode/11",
                "https://rickandmortyapi.com/api/episode/22",
                "https://rickandmortyapi.com/api/episode/51"
             ],
             "url":"https://rickandmortyapi.com/api/character/389",
             "created":"2018-01-10T19:57:41.191Z"
          },
          {
             "id":390,
             "name":"Zick Zack",
             "status":"Dead",
             "species":"Alien",
             "type":"Floop Floopian",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"Earth (Replacement Dimension)",
                "url":"https://rickandmortyapi.com/api/location/20"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/390.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/29"
             ],
             "url":"https://rickandmortyapi.com/api/character/390",
             "created":"2018-01-10T20:00:05.681Z"
          },
          {
             "id":391,
             "name":"Uncle Steve",
             "status":"Dead",
             "species":"Alien",
             "type":"Parasite",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"Earth (Replacement Dimension)",
                "url":"https://rickandmortyapi.com/api/location/20"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/391.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/15"
             ],
             "url":"https://rickandmortyapi.com/api/character/391",
             "created":"2018-01-14T13:34:50.096Z"
          },
          {
             "id":392,
             "name":"Bearded Morty",
             "status":"Alive",
             "species":"Human",
             "type":"",
             "gender":"Male",
             "origin":{
                "name":"unknown",
                "url":""
             },
             "location":{
                "name":"Citadel of Ricks",
                "url":"https://rickandmortyapi.com/api/location/3"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/392.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/28",
                "https://rickandmortyapi.com/api/episode/51"
             ],
             "url":"https://rickandmortyapi.com/api/character/392",
             "created":"2018-01-14T14:48:05.977Z"
          },
          {
             "id":393,
             "name":"Roy",
             "status":"Alive",
             "species":"Human",
             "type":"Game",
             "gender":"Male",
             "origin":{
                "name":"Roy: A Life Well Lived",
                "url":"https://rickandmortyapi.com/api/location/32"
             },
             "location":{
                "name":"Roy: A Life Well Lived",
                "url":"https://rickandmortyapi.com/api/location/32"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/393.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/13"
             ],
             "url":"https://rickandmortyapi.com/api/character/393",
             "created":"2018-01-20T19:15:27.239Z"
          },
          {
             "id":394,
             "name":"Davin",
             "status":"Dead",
             "species":"Cronenberg",
             "type":"",
             "gender":"Male",
             "origin":{
                "name":"Earth (C-137)",
                "url":"https://rickandmortyapi.com/api/location/1"
             },
             "location":{
                "name":"Earth (C-137)",
                "url":"https://rickandmortyapi.com/api/location/1"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/394.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/6"
             ],
             "url":"https://rickandmortyapi.com/api/character/394",
             "created":"2018-01-20T19:48:42.201Z"
          },
          {
             "id":395,
             "name":"Greebybobe",
             "status":"Alive",
             "species":"Alien",
             "type":"Greebybobe",
             "gender":"unknown",
             "origin":{
                "name":"Girvonesk",
                "url":"https://rickandmortyapi.com/api/location/68"
             },
             "location":{
                "name":"Worldender's lair",
                "url":"https://rickandmortyapi.com/api/location/4"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/395.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/11",
                "https://rickandmortyapi.com/api/episode/16",
                "https://rickandmortyapi.com/api/episode/25"
             ],
             "url":"https://rickandmortyapi.com/api/character/395",
             "created":"2018-04-15T16:46:31.715Z"
          },
          {
             "id":396,
             "name":"Scary Teacher",
             "status":"Alive",
             "species":"Mythological Creature",
             "type":"Monster",
             "gender":"Male",
             "origin":{
                "name":"Mr. Goldenfold's dream",
                "url":"https://rickandmortyapi.com/api/location/18"
             },
             "location":{
                "name":"Mr. Goldenfold's dream",
                "url":"https://rickandmortyapi.com/api/location/18"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/396.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/2"
             ],
             "url":"https://rickandmortyapi.com/api/character/396",
             "created":"2018-04-15T17:10:07.639Z"
          },
          {
             "id":397,
             "name":"Fido",
             "status":"Alive",
             "species":"Animal",
             "type":"Dog",
             "gender":"Male",
             "origin":{
                "name":"Snuffles' Dream",
                "url":"https://rickandmortyapi.com/api/location/70"
             },
             "location":{
                "name":"Snuffles' Dream",
                "url":"https://rickandmortyapi.com/api/location/70"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/397.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/2"
             ],
             "url":"https://rickandmortyapi.com/api/character/397",
             "created":"2018-04-15T17:15:28.777Z"
          },
          {
             "id":398,
             "name":"Accountant dog",
             "status":"Alive",
             "species":"Animal",
             "type":"Dog",
             "gender":"Male",
             "origin":{
                "name":"Snuffles' Dream",
                "url":"https://rickandmortyapi.com/api/location/70"
             },
             "location":{
                "name":"Snuffles' Dream",
                "url":"https://rickandmortyapi.com/api/location/70"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/398.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/2"
             ],
             "url":"https://rickandmortyapi.com/api/character/398",
             "created":"2018-04-15T17:23:04.169Z"
          },
          {
             "id":399,
             "name":"Tiny-persons advocacy group lawyer",
             "status":"Alive",
             "species":"Mythological Creature",
             "type":"Giant",
             "gender":"Male",
             "origin":{
                "name":"Giant's Town",
                "url":"https://rickandmortyapi.com/api/location/14"
             },
             "location":{
                "name":"Giant's Town",
                "url":"https://rickandmortyapi.com/api/location/14"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/399.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/5"
             ],
             "url":"https://rickandmortyapi.com/api/character/399",
             "created":"2018-04-15T17:34:02.076Z"
          },
          {
             "id":400,
             "name":"Giant Judge",
             "status":"Alive",
             "species":"Mythological Creature",
             "type":"Giant",
             "gender":"Male",
             "origin":{
                "name":"Giant's Town",
                "url":"https://rickandmortyapi.com/api/location/14"
             },
             "location":{
                "name":"Giant's Town",
                "url":"https://rickandmortyapi.com/api/location/14"
             },
             "image":"https://rickandmortyapi.com/api/character/avatar/400.jpeg",
             "episode":[
                "https://rickandmortyapi.com/api/episode/5"
             ],
             "url":"https://rickandmortyapi.com/api/character/400",
             "created":"2018-04-15T17:36:11.295Z"
          }
       ]
    }
""".trimIndent()