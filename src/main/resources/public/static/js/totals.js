/**
 * 当前流程
 */
let currentFlow = 0;
/**
 * 当前PK数据
 */
let currentPkData = [{ "id": 1, "team": "红队", "ronda": "1", "name": "李汶翰", "athleteValue": 389, "audienceValue": 354, "score": 35 }, { "id": 2, "team": "蓝队", "ronda": "1", "name": "黄明昊Justin", "athleteValue": 388, "audienceValue": 368, "score": 20, "v": 2 }, { "id": 3, "team": "红队", "ronda": "2", "name": "S.K.Y天空少年", "athleteValue": 399, "audienceValue": 371, "score": 28 }, { "id": 4, "team": "蓝队", "ronda": "2", "name": "乐华NEXT", "athleteValue": 366, "audienceValue": 380, "score": 14, "v": 2 }, { "id": 5, "team": "红队", "ronda": "3", "name": "宝石Gem", "athleteValue": 365, "audienceValue": 392, "score": 27, "v": 2 }, { "id": 6, "team": "蓝队", "ronda": "3", "name": "张蔷", "athleteValue": 398, "audienceValue": 363, "score": 35 }, { "id": 7, "team": "红队", "ronda": "4", "name": "刘思鉴", "athleteValue": 346, "audienceValue": 344, "score": 2, "v": 2 }, { "id": 8, "team": "蓝队", "ronda": "4", "name": "范丞丞", "athleteValue": 372, "audienceValue": 365, "score": 7 }];


/**
 * 初始化UI
 */
function flow0() {
    $("#left_1").html("");
    $("#left_2").html("");
    $("#left_3").html("");
    $("#left_4").html("");
    $("#right_1").html("");
    $("#right_2").html("");
    $("#right_3").html("");
    $("#right_4").html("");
}


function flow1() {
    var lanData = currentPkData.filter(item => item.ronda == "2" && item.team == "蓝队");
    var hongData = currentPkData.filter(item => item.ronda == "2" && item.team == "红队");
    $("#left_1").html(hongData[0].score);
    $("#right_1").html(lanData[0].score);
}


function flow2() {
    var lanData = currentPkData.filter(item => item.ronda == "3" && item.team == "蓝队");
    var hongData = currentPkData.filter(item => item.ronda == "3" && item.team == "红队");
    $("#left_2").html(hongData[0].score);
    $("#right_2").html(lanData[0].score);
}


function flow3() {
    var lanData = currentPkData.filter(item => item.ronda == "4" && item.team == "蓝队");
    var hongData = currentPkData.filter(item => item.ronda == "4" && item.team == "红队");
    $("#left_3").html(hongData[0].score);
    $("#right_3").html(lanData[0].score);
}

function flow4() {
    var hongScore = parseInt($("#left_1").html()) + parseInt($("#left_2").html()) + parseInt($("#left_3").html());
    var lanScore = parseInt($("#right_1").html()) + parseInt($("#right_2").html()) + parseInt($("#right_3").html());

    $("#left_4").html(hongScore);
    $("#right_4").html(lanScore);
}

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
 * 监听键盘
 */
$(document).keydown(function (event) {
    if (event.keyCode == 32) {
        currentFlow = currentFlow + 1;
        if (currentFlow > 4) {
            currentFlow = 0;
        }
        eval("flow" + currentFlow + "()");
    } else if (event.keyCode == 65) {
        fullScreen();
    }
});


/**
 * 初始化数据
 */
$(document).ready(function () {


    // 加载PK数据
    $.post(serviceUrl + "/voter/AthleteInfoConnector/getAthleteInfo", function (data, status) {
        if (data.length != 8) {
            alert("获取选手数据异常：获取到" + data.length + "条数据！");
        } else {
            currentPkData = data;
        }
    });
});

/**
 * 1秒钟从后台拿一次PK数据
 */
window.setInterval(function () {
    // 加载PK数据
    $.post(serviceUrl + "/voter/AthleteInfoConnector/getAthleteInfo", function (data, status) {
        if (data.length != 8) {
            alert("获取选手数据异常：获取到" + data.length + "条数据！");
        } else {
            currentPkData = data;
        }
    });
}, 1000);

    // // 是否全屏
    // isFull = getUrlParam("isFull");
    // if (null != isFull && "yes" == isFull) {
    //     fullScreen();
    // }