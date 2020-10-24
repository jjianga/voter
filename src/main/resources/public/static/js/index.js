/**
 * 当前PK数据
 */
let currentPkData = [{ "id": 1, "team": "红队", "ronda": "1", "name": "李汶翰", "athleteValue": 389, "audienceValue": 354, "score": 35 }, { "id": 2, "team": "蓝队", "ronda": "1", "name": "黄明昊Justin", "athleteValue": 388, "audienceValue": 368, "score": 20, "v": 2 }, { "id": 3, "team": "红队", "ronda": "2", "name": "S.K.Y天空少年", "athleteValue": 399, "audienceValue": 371, "score": 28 }, { "id": 4, "team": "蓝队", "ronda": "2", "name": "乐华NEXT", "athleteValue": 366, "audienceValue": 380, "score": 14, "v": 2 }, { "id": 5, "team": "红队", "ronda": "3", "name": "宝石Gem", "athleteValue": 365, "audienceValue": 392, "score": 27, "v": 2 }, { "id": 6, "team": "蓝队", "ronda": "3", "name": "张蔷", "athleteValue": 398, "audienceValue": 363, "score": 35 }, { "id": 7, "team": "红队", "ronda": "4", "name": "刘思鉴", "athleteValue": 346, "audienceValue": 344, "score": 2, "v": 2 }, { "id": 8, "team": "蓝队", "ronda": "4", "name": "范丞丞", "athleteValue": 372, "audienceValue": 365, "score": 7 }];

/**
 * 打开单场PK看板
 */
function openOnce() {
    var cc = $('#cc').val();
    var sxs = $('#sxs').val();
    window.open("once.html?currentRond=" + cc + "&currentTeam=" + sxs);
}

/**
 * 打开单场PK看板
 */
function saveServiceUrl() {
    serviceUrl = $("#serviceUrl").val();
    alert("临时设置成功，如果您想永久设置，请在'/static/js/config.js'中修改配置！");
}

/**
 * 监听键盘
 */
$(document).keydown(function (event) {
     if (event.keyCode == 65) {
        fullScreen();
    }
});

/**
 * 全屏
 */
function fullScreen() {
    var el = document.documentElement;
    var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullscreen;
    if (typeof rfs != "undefined" && rfs) {
        rfs.call(el);
    };
    return;
}


/**
 * 初始化数据
 */
$(document).ready(function () {
    // 加载PK数据
    $("#serviceUrl").val(serviceUrl);
});