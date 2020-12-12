// active1 头部导航栏
$(function () {
    $('#ad_funnavbg a').each(function (e) {
        var href = $(this).attr('href');
        if(location.pathname == $(this).attr('href')) {
            $('#ad_funnavbg a').removeClass('active1');
            $(this).addClass('active1');
        }
    });
});
// active1 左侧导航栏
$(function () {
    $('.adlist a').each(function (e) {
        var href = $(this).attr('href');
        if(location.pathname == $(this).attr('href')) {
            $('.adlist a').removeClass('active1');
            $(this).addClass('active2');
        }
    });
});
$(function () {
    //图片预览
    $('#file0').change(function () {
    //    获取文件信息
        var objUrl =getObjectURL(this.files[0]);
        console.log("objUrl="+objUrl);
        if(objUrl){
            $('#adupimg0').attr('src',objUrl);
        }
    });
    // 歌曲预览
    $('#file1').change(function () {
        var musUrl = getObjectURL(this.files[0]);
        if(musUrl){
            $('#adupaudio0').attr('src',musUrl);
        }
    });
    $('#file2').change(function () {
        var texturl = getObjectURL(this.files[0]);
        if(texturl){
            $('#aduptext0').load(texturl);
        }
    });
    $('#file3').change(function () {
        //    获取文件信息
        var objUrl =getObjectURL(this.files[0]);
        console.log("objUrl="+objUrl);
        if(objUrl){
            $('#lunboimg').attr('src',objUrl);
        }
    });
    //专辑封面上传
    $('#file4').change(function () {
        //    获取文件信息
        var objUrl =getObjectURL(this.files[0]);
        console.log("objUrl="+objUrl);
        if(objUrl){
            $('#forupimg').attr('src',objUrl);
        }
    });
    function  getObjectURL(file) {
        var url = null;
        if(window.createObjectURL!=undefined){
            url = window.createObjectURL(file);
        }else if(window.URL!=undefined){
            url = window.URL.createObjectURL(file);
        }else if(window.webkitURL!=undefined){
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
})



