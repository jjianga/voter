/**
 * 当前流程
 */
let currentFlow = 0;

/**
 * 出场顺序：红队hong，蓝队lan
 */
let currentTeam = "hong";

/**
 * 当前PK场次
 */
let currentRond = "1";

/**
 * 当前PK数据
 */
let currentPkData = [{ "id": 1, "team": "红队", "ronda": "1", "name": "李汶翰", "athleteValue": 389, "audienceValue": 354, "score": 35 }, { "id": 2, "team": "蓝队", "ronda": "1", "name": "黄明昊Justin", "athleteValue": 388, "audienceValue": 368, "score": 20, "v": 2 }, { "id": 3, "team": "红队", "ronda": "2", "name": "S.K.Y天空少年", "athleteValue": 399, "audienceValue": 371, "score": 28 }, { "id": 4, "team": "蓝队", "ronda": "2", "name": "乐华NEXT", "athleteValue": 366, "audienceValue": 380, "score": 14, "v": 2 }, { "id": 5, "team": "红队", "ronda": "3", "name": "宝石Gem", "athleteValue": 365, "audienceValue": 392, "score": 27, "v": 2 }, { "id": 6, "team": "蓝队", "ronda": "3", "name": "张蔷", "athleteValue": 398, "audienceValue": 363, "score": 35 }, { "id": 7, "team": "红队", "ronda": "4", "name": "刘思鉴", "athleteValue": 346, "audienceValue": 344, "score": 2, "v": 2 }, { "id": 8, "team": "蓝队", "ronda": "4", "name": "范丞丞", "athleteValue": 372, "audienceValue": 365, "score": 7 }];


/**
 * 初始化UI
 */
function flow0() {
    $("#hong_1").html("");
    $("#hong_2").html("");
    $("#hong_3").html("");
    $("#lan_1").html("");
    $("#lan_2").html("");
    $("#lan_3").html("");
    $(".zh_left").hide();
    $(".zh_right").hide();
    $(".wi_left").hide();
    $(".wi_right").hide();
}

/**
 * 展示自觉评分
 */
function flow1() {
    var data = {};
    if (currentTeam == "hong") {
        data = currentPkData.filter(item => item.ronda == currentRond && item.team == "红队");
    } else {
        data = currentPkData.filter(item => item.ronda == currentRond && item.team == "蓝队");
    }
    $("#" + currentTeam + "_1").html(data[0].athleteValue);
}

/**
 * 展示观众打分+差异分
 */
function flow2() {
    var data = {};
    if (currentTeam == "hong") {
        data = currentPkData.filter(item => item.ronda == currentRond && item.team == "红队");
    } else {
        data = currentPkData.filter(item => item.ronda == currentRond && item.team == "蓝队");
    }
    $("#" + currentTeam + "_2").html(data[0].audienceValue);
    $("#" + currentTeam + "_3").html(data[0].score);
}

/**
 * 展示自觉评分(第二次)
 */
function flow3() {
    if (currentTeam == "hong") {
        currentTeam = "lan"
    } else {
        currentTeam = "hong"
    }
    flow1();
}

/**
 * 展示观众打分+差异分+WIN+灰屏
 */
function flow4() {
    // 观众打分 + 差异分
    flow2();
    // 显示WIN + 灰屏
    var lanData = currentPkData.filter(item => item.ronda == currentRond && item.team == "蓝队");
    var hongData = currentPkData.filter(item => item.ronda == currentRond && item.team == "红队");
    // 检查胜利的一方
    var shengli = ""
    if (lanData[0].score == hongData[0].score) {
        if (lanData[0].audienceValue > hongData[0].audienceValue) {
            shengli = "lan";
        } else {
            shengli = "hong";
        }
    } else if (lanData[0].score > hongData[0].score) {
        shengli = "hong";
    } else {
        shengli = "lan";
    }
    // 展示数据
    if (shengli == "hong") {
        // 红队胜利
        $(".wi_left").show();
        $(".zh_right").show();
    } else {
        // 蓝队胜利
        $(".wi_right").show();
        $(".zh_left").show();
    }
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
 * 从URL中拿数据
 * @param {*} name 
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

/**
 * 监听键盘
 */
$(document).keydown(function (event) {
    if (event.keyCode == 32) {
        currentFlow = currentFlow + 1;
        if (currentFlow > 4) {
            // 出场顺序
            currentTeam = getUrlParam("currentTeam");
            if (null == currentTeam) {
                currentTeam = "hong"
            }
            // 当前PK场次
            currentRond = getUrlParam("currentRond");
            if (null == currentRond) {
                currentRond = 1;
            }
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


    // 出场顺序
    currentTeam = getUrlParam("currentTeam");
    if (null == currentTeam) {
        currentTeam = "hong"
    }
    // 当前PK场次
    currentRond = getUrlParam("currentRond");
    if (null == currentRond) {
        currentRond = 1;
    }
    // 修改背景图数据
    var dt_bgUrl = "static/image/round_" + currentRond + ".png";
    $(".dt_bg").css("background-image", "url(" + dt_bgUrl + ")");

    var zh_leftUrl = "static/image/round_" + currentRond + "_left.png";
    $(".zh_left").css("background-image", "url(" + zh_leftUrl + ")");

    var zh_rightUrl = "static/image/round_" + currentRond + "right.png";
    $(".zh_right").css("background-image", "url(" + zh_rightUrl + ")");

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

