
// active
$(function () {
    $('#m_header a').each(function (e) {
        var href = $(this).attr('href');
        if(location.pathname == $(this).attr('href')) {
            $('#m_header a').removeClass('active');
            $(this).addClass('active');
        }
    });
});
// active3
$(function () {
    $('.userheader a').each(function (e) {
        var href = $(this).attr('href');
        if(location.pathname == $(this).attr('href')) {
            $('.userheader a').removeClass('active2');
            $(this).addClass('active2');
        }
    });
});
// 轮播图js
$(document).ready(function(){
    // 1.获取最外层
    var m_carousel = $(".m_carousel")
    var srcLength = $(".showNav span").length;

    // 存储的图片
        //  2.获取ul
        ul = m_carousel.find("ul"),
        // 3.获取按钮
        clickNum=m_carousel.find(".showNav span")
    // 3.获取每个图片的宽度
        eveWidth = m_carousel.find("ul li").eq(0).width();
        // 4.定时器，主要用户关闭定时器
        var timer = null;
        //5.为正在展示的图片索引值，当用户打开网页是首先显示第一张，即索引值为0
        var imgNow = 0;
        // 6.未按钮绑定一个点击事件
        clickNum.on("click",function(){
            // 点击这个按钮的时候给这个按钮加高光，同时去掉其他的
            $(this).addClass("active").siblings().removeClass("acitve")
            // 7.设置索引下标，获取点击值
            var index = $(this).index();
            ul.animate({
                // 8.让ul左移N个图片的大小宽度，N根据被点击的按钮索引值imgnow决定
                "left":-eveWidth*imgNow,
            })
        });
        timer = setInterval(function(){
            //让图片的索引依次加1
             imgNow ++
            // 当到达最后一张图时，让imgnow复制为第一张图的索引值，轮播图调到第一张重新开始
            if(imgNow == srcLength){
                imgNow=0
            }
            // 模拟触发数字按钮的click
            clickNum.eq(imgNow).trigger("click")
        },5000)
    })

// 显示图标
$(function() {
    $(".table_list tr").mouseover(function () {
        $(".table_list .a1,.table_list .a2,.table_list .a3,.table_list .a4").css("display", "block");
    });
    $(".table_list tr").mouseout(function () {
        $(".table_list .a1,.table_list .a2,.table_list .a3,table_list .a4").css("display", "none");

    });
});
// 回到顶部 当页面的滚动条距离最上方有50个像素时
$(function () {
    $(window).scroll(function () {
        if ($(window).scrollTop() >= 50) {
            $('#gotoTop1').fadeIn();
        }
        else {
            $('#gotoTop1').fadeOut();
        }
    });
});
$(function (){
    $('#gotoTop1').click(function () {
        $('html,body').animate({ scrollTop: 0 }, 500);
    });
})


// 登录注册
$(function(){
    $('.u_login').click(function(){
        $('.u_loginon').css('display',"block");
        $('.u_registeron').css('display','none');
        // console.log(1)
    });
    $('.u_register').click(function(){
        $('.u_loginon').css('display',"none");
        $('.u_registeron').css('display','block');
        // console.log(2)
    });
    $(function () {
        $('.ulogin a').click(function (e) {
            $('.ulogin a').removeClass('active1');
            $(this).addClass('active1');
        });
    });
})


//登录成功后指向用户时，可显示的下拉框
$(function(){
    $('.logo_login .login').mouseover(function() {
        $('.loginout').css('display','block');
    });
    $('.logo_login .login').mouseout(function() {
        $('.loginout').css('display','none');
    });
    $('.loginout').mouseover(function() {
        $('.loginout').css('display','block');
    });
    $('.loginout').mouseout(function() {
        $('.loginout').css('display','none');
    });
});
//登录
$(function(){
    $('#loginbtn').click(function () {
        $.ajax({
            type:"GET",
            dataType:"json",
            url:"/user/login",
            data:$("#loginform").serialize(),
            success:function (result) {
                // console.log(result)
                if(result == null){
                    alert("请先注册！！！")
                }else {
                    if(result == true){
                        alert("欢迎回来!!!")
                    }
                }
            },
            error:function(){
                alert("登录失败，请核对用户名密码!!!")
            }
        });
    })
})
//注册
$(function(){
    $('#registerbtn').click(function () {
        $.ajax({
            type:"GET",
            dataType:"json",
            url:"/user/register",
            data:$("#registerform").serialize(),
            success:function (result) {
                // console.log(result)
                if(result == true){
                    alert("注册成功！！！请返回登录！！！")
                }
            },
            error:function(){
                alert("注册失败！！！请检查是否有未输入！！！")
            }
        });
    })
})
//管理员登录
$(function(){
    $('#adminbtn').click(function () {
        $.ajax({
            type:"GET",
            dataType:"json",
            url:"/admin/login",
            data:$("#adminform").serialize(),
            success:function (result) {
                // console.log(result)
                if(result == null){
                    alert("没有此用户！！！")
                }else {
                    if(result == true){
                        alert("欢迎回来!!!")
                        location.href="/admin/admin";
                    }
                }
            },
            error:function(){
                alert("登录失败，请核对用户名密码!!!")
            }
        });
    })
})
//
// $(function () {
//     $('.musiclisten').click(function () {
//         // alert($("[id='${model}']").val());
//         // var music = $.parseJSON(id);
//         // alert(music);
//         alert($(this).attr(id));
//         console.log(1);
//     });
// })
//获取歌曲信息存放在session里
    function btn(id) {
        var music = $.parseJSON(id);
        var musicimg,musicname,singer,url;
        musicimg = music.musicimg;
        musicname = music.musicname;
        singer = music.singerSingername;
        url = music.musicurl;
        // alert(url);
        localStorage.setItem("musicname",musicname);
        localStorage.setItem("singer",singer);
        localStorage.setItem("musicimg",musicimg);
        localStorage.setItem("url",url);
    }

//评论获取的时间和musicname

window.onload=function () {
    var date=new Date();
    var year=date.getFullYear();
    var month=date.getMonth()+2;
    var day=date.getDate();
    var hour=date.getHours();
    var minute=date.getMinutes();
    var second=date.getSeconds();
    var time=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
    document.getElementById("date").value=time;
}
function comment(name) {
    var music = name;
    var musicname = document.getElementsByClassName("commentmusic")[0]
    musicname.value=music;
}
    $(function () {
        $(".commentbtn").click(function(){
            $.ajax({
                type:"GET",
                dataType:"json",
                url:"/music/userComment",
                data:$("#commentform").serialize(),
                success:function (result) {
                    // console.log(result)
                    if(result == true){
                        alert("发表成功!!!")
                        window.location.href("/music/comment")
                    }else{
                        alert("请先登录")
                        location.href("/music/musicindex");
                    }
                },

            });
        })
    })
//收藏

        function shoucang(id){
            console.log(1);
            $.get("/user/collect?musicname="+id,{},function(result){
                if(result == "null"){
                    alert("请登录")
                }
                if(result == "have"){
                    alert("收藏成功")

                }
                if(result == "has"){
                    alert("已收藏")
                }
            })
        };

//头像预览
$(function () {
    //图片预览
    $('#file4').change(function () {
        //    获取文件信息
        var objUrl =getObjectURL(this.files[0]);
        console.log("objUrl="+objUrl);
        if(objUrl){
            $('#userimg1').attr('src',objUrl);
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

// $(function () {
//     $('#sure_edit').click(function () {
//         $('#reset').click();
//         $.ajax({
//             type:"get",
//             dataType:"json",
//             url:"/admin/edit",
//             data:$('#edit').serialize(),
//             success : function (result) {
//                 if(result == 1){
//                     alert("修改成功")
//                     window.location.reload();
//                 }
//                 if (result == 2){
//                     alert("新密码和确认密码不一致！")
//                 }
//                 if(result == 3){
//                     alert("密码错误，请重新输入！")
//                 }
//             }
//         })
//     })
// })
