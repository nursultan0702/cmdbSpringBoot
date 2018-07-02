function createBtn() {
    var $creatorSteamId = $("#steamid").val();
    var $map = $("#map").val();
    var $maxplayer = $("#maxplayer").val();
    var $playerssteamid = $("#playerssteamid").val()
    var data = { creatorSteamId: $creatorSteamId, maxPlayers: $maxplayer, isPublic: true, mapName: $map, players: $maxplayer };

    $.ajax({
        type: "POST",
        url: "/start",
        // The key needs to match your method's input parameter (case-sensitive).
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){alert(data);},
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
    $("#serverip").val("37.151.106.142:27015")
}

function stopBtn() {
    $.get("http://37.151.106.142:8585/stop")
    $("#serverip").val("Server is stoped")
}

function steamReg() {
    //$.get("http://localhost/steam/steamauth/steamauth.php?login");
    window.location.replace("http://localhost/steam/steamauth/steamauth.php?login");

}