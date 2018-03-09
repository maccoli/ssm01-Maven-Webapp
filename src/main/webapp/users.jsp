<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
  <title>后台-用户分析</title>
  <meta charset="UTF-8">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link rel="shortcut icon" href="static/favicon.ico" mce_href="favicon.ico" type="image/x-icon">
  <link href="css/templatemo-style.css" rel="stylesheet">
</head>

<body>
  <div class="templatemo-flex-row">
    <div class="templatemo-sidebar">
      <header class="templatemo-site-header">
        <div class="square"></div>
        <h1>郷野 · 故事</h1>
      </header>
      <div class="profile-photo-container">
        <img src="img/headpic/moren.jpg" alt="Profile Photo" class="img-responsive">
        <div class="profile-photo-overlay"></div>
      </div>
      <!-- <div class="templatemo-search-number">
        本站访问量为 222
      </div> -->
      <!-- Search box -->
      <form class="templatemo-search-form" role="search">
        <div class="input-group">
          <button type="submit" class="fa fa-search"></button>
          <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
        </div>
      </form>
      <div class="mobile-menu-icon">
        <i class="fa fa-bars"></i>
      </div>
      <nav class="templatemo-left-nav">
        <ul>
          <li><a href="home.jsp"><i class="fa fa-home fa-fw"></i>主页</a></li>
          <li><a href="countrysides.jsp"><i class="fa fa-map-marker fa-fw"></i>乡村分析</a></li>
          <li><a href="users.jsp" class="active"><i class="fa fa-users fa-fw"></i>用户分析</a></li>
          <li><a href="addCheck.jsp"><i class="fa fa-database fa-fw"></i>添加审核</a></li>
          <li><a href="tipCheck.jsp"><i class="fa fa-sliders fa-fw"></i>举报信息审核</a></li>
          <li><a href="loginOut.jsp"><i class="fa fa-eject fa-fw"></i>登入/登出</a></li>
        </ul>
      </nav>
    </div>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
      <div class="templatemo-content-container">
        <!-- tip -->
        <div class="templatemo-flex-row flex-content-row">
          <div class="templatemo-content-widget col-1 white-bg" >
            <h2 style="font-size:16px;" id="total_count"></h2>
          </div>
        </div>
        <!-- 用户列表 -->
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td style="width:15%;">#</td>
                  <td style="width:30%;">昵称</td>
                  <!-- <td style="width:17%;">类型</td> -->
                  <td style="width:15%;">发布游记篇数</td>
                  <td style="width:15%;">登录总时长</td>
                  <td style="width:25%;">最后一次登录时间</td>
                </tr>
              </thead>
              <tbody id="user_list">
                <!-- <tr>
                  <td>001</td>
                  <td>Silence12344</td>
                  <td>普通用户</td>
                  <td>12</td>
                  <td>00:02:35</td>
                  <td>2017-11-15 00:02:35</td>
                </tr> -->
            </table>
          </div>
        </div>
        <!-- 翻页 -->
        <div class="pagination-wrap">
          <ul class="pagination">
            <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li>
              <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
            </li>
          </ul>
        </div>
        <!-- 用户详情 -->
        <div class="templatemo-flex-row flex-content-row">
          <!-- 个人资料 -->
          <div class="templatemo-content-widget white-bg col-2"> 
            
            <div class="media margin-bottom-30" id="one_user_top">
              <div class="media-left padding-right-25">
                <a href="#">
                  <img class="media-object img-circle templatemo-img-bordered" src="images/person.jpg" alt="Sunset"></a>
              </div>
              <div class="media-body">
                <h2 class="media-heading text-uppercase blue-text">阿水1234</h2>
                <p>我就是我，不一样的烟火。</p>
              </div>
            </div>
            <div class="table-responsive">
              <table class="table">
                <tbody id="one_user_othersinfor">
                  <tr>
                    <td style="width:50px;">
                      <div class="circle green-bg"></div>
                    </td>
                    <td style="width:100px;">手机</td>
                    <td>15058330873</td>
                  </tr>
                  <tr>
                    <td style="width:50px;">
                      <div class="circle pink-bg"></div>
                    </td>
                    <td style="width:100px;">邮箱</td>
                    <td>1694886651@qq.com</td>
                  </tr>
                  <tr>
                    <td style="width:50px;">
                      <div class="circle blue-bg"></div>
                    </td>
                    <td style="width:100px;">微信</td>
                    <td>lianyihhhh</td>
                  </tr>
                  <tr>
                    <td style="width:50px;">
                      <div class="circle yellow-bg"></div>
                    </td>
                    <td style="width:100px;">爱好</td>
                    <td>远足 爬山 探险</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <!-- 用户的游记 -->
          <div class="templatemo-position-relative col-2" id="youji_show">
            <div class="templatemo-content-widget orange-bg"> 
              <div class="media">
                <div class="media-left">
                  <a href="#">
                    <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset"></a>
                </div>
                <div class="media-body">
                  <h2 class="media-heading text-uppercase">很难忘的一次旅行</h2>
                  <p>
                    2017-08-15
                  </p>
                </div>
              </div>
            </div>
            <div class="templatemo-content-widget white-bg"> 
              <div class="media">
                <div class="media-left">
                  <a href="#">
                    <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset"></a>
                </div>
                <div class="media-body">
                  <h2 class="media-heading text-uppercase">和他说走就走</h2>
                  <p>
                    2017-09-22
                  </p>
                </div>
              </div>
            </div>
          </div>
          <!-- 用户的收藏 -->
          <div class="templatemo-content-widget white-bg col-1 templatemo-content-img-bg" id="show_shoucang">
            <img src="img/scienspot/cover/c5.jpg" alt="Sunset" class="img-responsive content-bg-img">        
            <i class="fa fa-heart" title="已收藏"></i>
            <h2 class="templatemo-position-relative white-text">安吉竹博园</h2>
            <div class="view-img-btn-wrap">
              <a href="" class="btn btn-default templatemo-view-img-btn">查看</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="js/jquery-1.11.2.min.js"></script>
  <!-- jQuery -->
  <script type="text/javascript" src="js/templatemo-script.js"></script>
  <script type="text/javascript">

    function dateFormat (time) {
      var date = new Date(time);
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var day = date.getDate();
      var hour = date.getHours();
      var minute = date.getMinutes();
      var second = date.getSeconds();
      month = (String(month).length < 2) ? '0' + month : month;
      day = (String(day).length < 2) ? '0' + day : day;
      hour = (String(hour).length < 2) ? '0' + hour : hour;
      minute = (String(minute).length < 2) ? '0' + minute : minute;
      second = (String(second).length < 2) ? '0' + second : second;
      return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
    }

    function dateFormat1 (time) {
      var date = new Date(time);
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var day = date.getDate();
      month = (String(month).length < 2) ? '0' + month : month;
      day = (String(day).length < 2) ? '0' + day : day;
      return year + '-' + month + '-' + day;
    }

    $(function(){ 
      $.ajax({
        url : 'BackStage/showallUser',
        type : 'GET',
        success : function(data){
          var jsonArray = JSON.parse(data).list1;
          var userCount = JSON.parse(data).list2;
          var youjiCount = JSON.parse(data).list3;
          var outStr1  = "本站已注册用户有" + userCount + "名，发表游记总计" + youjiCount + "篇";
          var outStr2 = "";
          $.each(jsonArray,function(i,value){
            var jsonCell = value;
            var addFormatTime = dateFormat(jsonCell.lasttime);
            var outStr3 = jsonCell.articles;
            var outStr4 = jsonCell.alltime;
            var outStr5 = addFormatTime;
            if(jsonCell.articles == undefined){
              outStr3 = 0;
            }
            if(jsonCell.alltime == undefined){
              outStr4 = "00:00:00";
            }
            if(addFormatTime == "NaN-NaN-NaN NaN:NaN:NaN"){
              outStr5 = "00-00-00 00:00:00";
            }
            outStr2 += "<tr><td class='user_id_box'>" + jsonCell.userid + "</td><td class='user_line_box'>" + jsonCell.username + "</td><td>" + outStr3 + "</td><td>" + outStr4 + "</td><td>" + outStr5 + "</td></tr>";
          });
          $("#total_count").html(outStr1);
          $("#user_list").html(outStr2);
        },
        error : function(){
          console.log("服务器被天狗吃掉了，获取数据失败~");
        }
      });
    });
    // $(".user_line_box").click(function (){
    $("body").on("click",".user_line_box",function(){
      x = $(this).index(".user_line_box");
      var json = {};
      json.id = $(".user_id_box").eq(x).text();
      $.ajax({
        url : 'BackStage/showUserone',
        type : 'GET',
        data :  json,
        success : function(data){
          var jsonArray = JSON.parse(data).list1;
          var outStr1  = "";
          var outStr2 = "";
          var outStr3 = "";
          var outStr4 = "";
          $.each(jsonArray,function(i,value){
            var jsonCell = value;
            var list2Long = 3;
            outStr1 += "<div class='media-left padding-right-25'><a href='#'><img class='media-object img-circle templatemo-img-bordered' src='" + jsonCell.headpic + "' alt='Sunset'></a></div><div class='media-body'><h2 class='media-heading text-uppercase blue-text'>" + jsonCell.username + "</h2><p>" + jsonCell.jianjie + "</p></div>";
            outStr2 = "<tr><td style='width:50px;'><div class='circle green-bg'></div></td><td style='width:100px;'>手机</td><td>" + jsonCell.phone + "</td></tr><tr><td style='width:50px;'><div class='circle pink-bg'></div></td><td style='width:100px;'>邮箱</td><td>" + jsonCell.useremail + "</td></tr><tr><td style='width:50px;'><div class='circle blue-bg'></div></td><td style='width:100px;'>微信</td><td>" + jsonCell.wechat + "</td></tr><tr><td style='width:50px;'><div class='circle yellow-bg'></div></td><td style='width:100px;'>爱好</td><td>" + jsonCell.favorite + "</td></tr>"
            if(jsonCell.list2 == undefined || jsonCell.list2 == null || jsonCell.list2 == 0){
              list2Long = 0
            } else {
              if(jsonCell.list2.length < list2Long){
                list2Long = jsonCell.list2.length
              }
            }
            if(list2Long == 0){
              outStr3 += "<div class='templatemo-content-widget white-bg'><div class='media'>该用户未留下一点蛛丝马迹</div></div>";
            }
            $.each(jsonCell.list2,function(i,value){
              var yjOne = value;
              if(i > list2Long){
                return false;
              }
              var lettimeFormate = dateFormat1(yjOne.articletime);
              outStr3 += "<div class='templatemo-content-widget white-bg'><div class='media'><div class='media-left'><a href='#'><img class='media-object img-circle' src='" + yjOne.mainpic + "' alt=''></a></div><div class='media-body'><h2 class='media-heading text-uppercase'>" + yjOne.name + "</h2><p>" + lettimeFormate + "</p></div></div></div>";
            });
            if(jsonCell.list3.length == 0){
              outStr4 = "<img src='images/sunset-big.jpg' class='img-responsive content-bg-img'><h2 class='templatemo-position-relative white-text'>用户暂无收藏</h2>";
            }
            else{
              outStr4 = "<img src='" + jsonCell.list3[0].cover + "' class='img-responsive content-bg-img'><i class='fa fa-heart' title='已收藏'></i><h2 class='templatemo-position-relative white-text'>" + jsonCell.list3[0].sname + "</h2><div class='view-img-btn-wrap'><a href='' class='btn btn-default templatemo-view-img-btn'>View</a></div>";
            }
          });
          $("#one_user_top").html(outStr1);
          $("#one_user_othersinfor").html(outStr2);
          $("#youji_show").html(outStr3);
          $("#show_shoucang").html(outStr4);
        },
        error : function(){
          console.log("服务器被天狗吃掉了，获取数据失败~");
          // var data = '{"list1":[{"headpic":"images/person.jpg","username":"qianyierin","jianjie":"我就是我颜色不一样的烟火","phone":"125********","useremail":"16948866@qq.com","wechat":"keufhhyce","favorite":"远足 爬山 游泳","list2":[{"mainpic":"images/person.jpg","name":"说走就走的旅行","articletime":"2017-08-17"}],"list3":[{"sname":"安吉竹博园111","cover":"images/sunset.jpg"}]}]}';
          
        }
      });
    });
  </script>
</body>

</html>