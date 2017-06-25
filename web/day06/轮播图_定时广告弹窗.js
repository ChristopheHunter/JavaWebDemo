/**
 * Created by zy_git on 2017/6/23.
 */
//定是操作
function init() {
    setInterval("changeImg()", 2000);
    time = setInterval("showAd()", 2000);       //定义全局变量保存setInterval返回值
}

//自动切换的函数
var index = 1;
function changeImg() {
    index++;
    document.getElementById("img1").src = "../../img/" + index + ".jpg";
    if (index == 3) {
        index = 0;
    }
}

//定时弹出广告
function showAd() {
    var adEle = document.getElementById("ad_big");
    adEle.style.display = "block";
    clearInterval(time);
    time2 = setInterval("hideAd()",2000);
}

//定时关闭广告
function hideAd() {
    document.getElementById("ad_big").style.display = "none";
    clearInterval(time2);
}
