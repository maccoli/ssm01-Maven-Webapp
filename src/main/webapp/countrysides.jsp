<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">

<head>
  <title>后台-乡村分析</title>
  <meta charset="UTF-8">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/templatemo-style.css" rel="stylesheet">
  <link rel="shortcut icon" href="static/favicon.ico" mce_href="favicon.ico" type="image/x-icon">
  <style>
    .map {
      width: 100%;
      height: 600px;
      margin-left: -100px;
      position: relative;
    }

    .map-bg-img {
      /* 背景图片 */
      width: 100%;
      height: 100%;
      position: absolute;
      top: 0;
      left: 0;
    }

    .map-bg-gary {
      /* 背景灰色蒙版 */
      background: rgba(24, 24, 24, 0.7);
      width: 100%;
      height: 100%;
      position: absolute;
      top: 0;
      left: 0;
    }

    .map-img-1 {
      /* 地图全局图片和热点选区 包裹，距顶部50px */
      position: absolute;
      width: 50%;
      height: 90%;
      top: 50px;
      left: 0;
      z-index: 1000;
    }

    .map-img-2 {
      /* 地图全局图片和热点选区 距右边100px */
      margin: 0 100px;
      width: 605px;
      height: 450px;
    }

    .map-areas {
      /* 地图局部 */
      position: absolute;
      width: 100%;
      height: 90%;
      top: 50px;
      left: 0;
      z-index: 90;
    }

    .map-areas img {
      /* 地图局部图片 */
      position: absolute;
      left: 100px;
      width: 605px;
      height: 450px;
    }

    .area {
      /* 地图热点样式 */
      outline: none;
    }

    .map-point {
      /* 地图村落点 */
      position: absolute;
      width: 30px;
      height: 30px;
      z-index: 2000;
      background: red;
      cursor: pointer;
      background: url(images/point.png) no-repeat center center;
      background-size: 30px
    }

    .map-areaName {
      /* 地图乡镇名字 */
      position: absolute;
      z-index: 1005;
      color: #999;
      font-size: 14px;
    }

    .map-texts {
      position: absolute;
      width: 30%;
      height: 100px;
      z-index: 90;
      top: 40%;
      right: 15%;
      transform: translateY(-50%);
      text-align: center;
    }

    .map-texts a {
      color: #ffffff;
      font-size: 48px;
      line-height: 100px;
      height: 100px;
      display: block;
      width: 100%;
    }
  </style>
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
          <li><a href="countrysides.jsp" class="active"><i class="fa fa-map-marker fa-fw"></i>乡村分析</a></li>
          <li><a href="users.jsp"><i class="fa fa-users fa-fw"></i>用户分析</a></li>
          <li><a href="addCheck.jsp"><i class="fa fa-database fa-fw"></i>添加审核</a></li>
          <li><a href="tipCheck.jsp"><i class="fa fa-sliders fa-fw"></i>举报信息审核</a></li>
          <li><a href="loginOut.jsp"><i class="fa fa-eject fa-fw"></i>登入/登出</a></li>
        </ul>
      </nav>
    </div>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
      <div class="templatemo-content-container">
        <!-- 地图加简介 -->
        <div class="templatemo-flex-row flex-content-row">
          <div class="templatemo-content-widget blue-bg col-3">
            <!-- <img src="images/map.png" width="100%;" height="" /> -->
            <div class="map">
              <div class="map-img-1">
                <div class="map-img-2">
                  <img src="images/allArea.png" usemap="#Map" border="0" width="605px" height="450px" />
                  <map name="Map" id="Map">
                    <area class="area area1 " href="javascript:;" title="area1" shape="poly" coords="299,31,295,34,288,37,284,47,280,56,275,61,270,66,264,78,259,87,268,93,272,97,278,98,285,102,289,98,293,95,300,95,303,86,310,84,322,91,330,93,340,99,348,105,356,108,358,111,364,107,373,107,381,109,388,114,392,107,394,97,399,90,402,84,405,77,414,71,415,58,419,47,412,34,403,31,391,36,385,38,379,37,373,41,365,38,355,37,354,28,345,25,332,28,321,31,313,36,304,30" />
                    <area class="area area2" href="javascript:;" title="area2" shape="poly" coords="442,30,438,35,437,41,436,49,426,47,419,50,416,57,415,71,408,77,403,84,398,94,394,98,393,109,387,115,394,119,399,123,402,116,407,115,410,119,417,118,420,106,430,116,437,122,445,115,451,119,451,124,465,123,478,131,488,130,485,116,477,106,465,100,456,93,450,89,450,68,461,67,469,65,472,58,472,47,470,40,462,34,457,33,450,31" />
                    <area class="area area3" href="javascript:;" title="area3" shape="poly" coords="259,89,254,94,249,102,248,109,238,109,228,103,219,106,218,119,216,129,214,141,212,150,215,159,218,163,216,169,213,177,206,180,206,187,218,185,228,184,227,174,232,170,238,173,241,177,246,174,243,173,237,165,237,157,243,155,252,149,258,138,267,126,280,128,283,124,281,118,286,114,286,106,284,101,273,98,267,93" />
                    <area class="area area4" href="javascript:;" title="area4" shape="poly" coords="301,95,291,94,285,100,286,109,287,114,281,117,283,125,280,129,268,126,259,135,257,143,252,149,245,155,236,157,236,162,240,168,243,173,254,172,260,175,267,173,274,180,274,186,291,187,297,183,297,176,302,169,308,165,311,158,314,152,320,144,322,139,327,134,334,132,340,129,346,123,352,120,359,115,356,110,350,108,342,103,334,98,330,95,322,93,315,89,309,85,302,89" />
                    <area class="area area5" href="javascript:;" title="area5" shape="poly" coords="419,107,419,116,409,119,404,117,400,121,395,122,396,131,386,133,399,139,394,145,410,147,412,153,420,159,422,168,434,171,434,156,443,155,445,142,443,128,441,121,430,116" />
                    <area class="area area6" href="javascript:;" title="area6" shape="poly" coords="361,110,358,116,345,124,336,132,327,133,322,137,322,142,313,153,308,165,310,171,314,180,320,189,321,198,315,206,307,209,295,210,287,214,286,222,283,233,278,239,271,242,270,251,275,257,282,259,289,265,292,270,299,271,302,275,307,274,315,271,327,270,324,278,325,285,338,284,345,290,349,296,348,307,348,321,353,328,362,333,371,335,382,336,378,323,371,315,367,308,382,298,392,309,428,310,438,313,451,307,454,299,452,290,457,285,456,276,449,265,445,261,448,252,453,242,456,234,451,228,451,221,452,213,450,209,448,199,441,196,433,197,432,188,432,183,433,175,432,169,422,168,420,162,417,157,412,153,410,147,393,147,397,139,389,135,384,133,394,133,394,128,394,122,395,118,386,116,385,112,375,109,367,108"/>
                    <area class="area area7" href="javascript:;" title="area7" shape="poly" coords="445,117,440,121,444,125,445,138,445,153,435,157,434,171,432,182,433,195,441,195,448,200,452,214,452,229,461,232,469,223,477,215,479,204,479,193,483,187,494,188,502,178,511,168,509,153,512,147,511,135,503,131,486,132,476,131,465,123,457,123,450,123,450,118" />
                    <area class="area area8" href="javascript:;" title="area8" shape="poly" coords="206,187,201,196,189,205,189,215,184,222,188,232,191,240,194,248,195,264,190,273,190,291,195,294,201,297,197,301,190,302,195,308,205,307,209,302,214,305,214,313,218,321,229,321,235,329,244,334,254,337,259,337,262,324,266,313,275,306,281,299,290,290,296,287,299,280,305,277,298,272,292,270,287,263,279,258,272,254,270,244,272,240,270,230,266,217,260,208,255,201,247,195,240,194,237,185,230,184,219,184" />
                    <area class="area area9" href="javascript:;" title="area9" shape="poly" coords="228,171,228,182,235,184,240,193,248,195,255,199,256,205,261,208,266,217,270,230,272,240,278,238,283,231,287,221,288,213,294,211,305,209,314,207,319,200,321,194,316,184,311,175,309,167,309,164,303,169,298,175,297,182,292,187,273,187,274,182,269,175,264,173,260,177,255,173,247,172,241,178,239,174,234,170" />
                    <area class="area area10" href="javascript:;" title="area10" shape="poly" coords="152,182,145,187,139,190,128,200,118,205,109,218,102,229,102,236,91,242,77,245,62,248,51,245,42,249,41,261,48,270,55,278,60,282,55,287,46,292,45,299,40,307,42,323,49,326,55,336,69,341,85,327,97,323,104,331,109,340,107,347,121,349,132,346,140,343,150,342,169,343,174,337,181,329,183,316,186,302,191,302,200,298,189,292,189,281,191,269,195,261,193,245,186,230,183,223,175,223,166,218,157,216,160,203,156,188" />
                    <area class="area area11" href="javascript:;" title="area11" shape="poly" coords="109,347,104,352,104,361,108,374,106,385,110,396,126,405,124,420,135,429,135,443,149,444,158,449,183,438,193,425,183,420,177,405,182,389,174,377,160,376,159,366,169,362,175,357,172,343,163,345,150,343,143,342,134,349,123,348" />
                    <area class="area area12" href="javascript:;" title="area12" shape="poly" coords="187,302,184,314,182,327,172,342,173,351,174,361,161,369,159,375,176,378,183,385,181,398,178,406,183,416,192,423,203,424,217,426,229,428,239,432,253,429,258,418,243,416,239,408,243,402,249,401,257,393,257,381,267,370,265,358,264,345,260,338,249,338,237,332,232,326,228,323,219,321,213,311,213,305,205,307" />
                    <area class="area area13" href="javascript:;" title="area13" shape="poly" coords="304,276,297,287,287,294,275,308,264,320,259,333,263,335,264,346,266,359,269,371,261,382,258,394,251,402,243,404,241,413,255,414,266,408,270,398,277,398,285,399,289,396,296,393,301,378,289,368,290,362,289,348,289,334,294,321,308,318,317,316,319,309,316,291,325,284,326,270,315,270" />
                    <area class="area area14" href="javascript:;" title="area14" shape="poly" coords="323,286,317,294,321,306,316,316,296,318,287,333,290,352,290,366,299,375,296,390,273,400,286,413,298,413,316,410,329,401,330,373,334,361,347,368,359,366,363,361,367,374,377,380,380,367,384,350,381,338,363,332,351,323,349,304,351,292,339,284" />
                    <area class="area area15" href="javascript:;" title="area15" shape="poly" coords="334,364,331,374,330,388,329,398,333,401,324,408,320,417,324,432,337,436,356,436,363,423,371,412,381,407,387,395,377,383,377,378,369,372,362,363,347,367" />
                  </map>
                </div>
              </div>
              <!-- 地图局部图片 -->
              <div class="map-areas">
                <img class="one-area" src="images/area1.png" style="display:none;">
                <img class="one-area" src="images/area2.png" style="display:none;">
                <img class="one-area" src="images/area3.png" style="display:none;">
                <img class="one-area" src="images/area4.png" style="display:none;">
                <img class="one-area" src="images/area5.png" style="display:none;">
                <img class="one-area" src="images/area6.png" style="display:none;">
                <img class="one-area" src="images/area7.png" style="display:none;">
                <img class="one-area" src="images/area8.png" style="display:none;">
                <img class="one-area" src="images/area9.png" style="display:none;">
                <img class="one-area" src="images/area10.png" style="display:none;">
                <img class="one-area" src="images/area11.png" style="display:none;">
                <img class="one-area" src="images/area12.png" style="display:none;">
                <img class="one-area" src="images/area13.png" style="display:none;">
                <img class="one-area" src="images/area14.png" style="display:none;">
                <img class="one-area" src="images/area15.png" style="display:block;">
              </div>
              <!-- 地图村落点定位点 -->
              <div class="map-points">
                <div class="map-point" style="top:290px;left:410px;display:none;" title="横山坞村"></div>
                <div class="map-point" style="top:320px;left:490px;display:none;" title="双一村"></div>
                <div class="map-point" style="top:325px;left:400px;display:none;" title="刘家塘村"></div>
                <div class="map-point" style="top:365px;left:400px;display:none;" title="余村村"></div>
                <div class="map-point" style="top:408px;left:445px;display:block;" title="马家弄村"></div>
                <div class="map-point" style="top:420px;left:452px;display:block;" title="高家堂村"></div>
                <div class="map-point" style="top:215px;left:335px;display:none;" title="尚书圩村"></div>
                <div class="map-point" style="top:195px;left:580px;display:none;" title="长林垓村"></div>
              </div>
              <!-- 地图局部地区名 -->
              <div class="map-areaNames">
                <div class="map-areaName" style="top:115px;left:420px;display:none;">高禹镇</div>
                <div class="map-areaName" style="top:133px;left:508px;display:none;">梅溪镇</div>
                <div class="map-areaName" style="top:174px;left:318px;display:none;">鄣吴镇</div>
                <div class="map-areaName" style="top:191px;left:365px;display:none;">良朋镇</div>
                <div class="map-areaName" style="top:179px;left:502px;display:none;">溪龙乡</div>
                <div class="map-areaName" style="top:260px;left:450px;display:none;">递铺镇</div>
                <div class="map-areaName" style="top:209px;left:545px;display:none;">昆铜乡</div>
                <div class="map-areaName" style="top:309px;left:321px;display:none;">孝丰镇</div>
                <div class="map-areaName" style="top:246px;left:366px;display:none;">皈山乡</div>
                <div class="map-areaName" style="top:321px;left:200px;display:none;">杭垓镇</div>
                <div class="map-areaName" style="top:418px;left:212px;display:none;">章村镇</div>
                <div class="map-areaName" style="top:413px;left:296px;display:none;">报福镇</div>
                <div class="map-areaName" style="top:378px;left:370px;display:none;">上<br/>野<br/>乡</div>
                <div class="map-areaName" style="top:390px;left:402px;display:none;">天荒坪镇</div>
                <div class="map-areaName" style="top:430px;left:445px;display:block;">山<br/>川<br/>乡</div>
              </div>
            </div>
          </div>
          <div class="templatemo-content-widget col-1 pink-bg" style="height:200px;">
            <h2 class="text-uppercase margin-bottom-10" id="country_name"></h2>
            <p class="margin-bottom-0" id="country_include"></p>
          </div>
        </div>
        <!-- 景点等列表 -->
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td style="width:40%;">名称</td>
                  <td style="width:20%;">类型</td>
                  <td style="width:25%;">添加时间</td>
                  <td style="width:15%;">被收藏数</td>
                </tr>
              </thead>
              <tbody id="showSRH">
                <!-- <tr>
                  <td>藏龙大瀑布</td>
                  <td>景点</td>
                  <td>2017-08-15</td>
                  <td>12</td>
                </tr>
                <tr>
                  <td>藏龙大瀑布</td>
                  <td>餐馆</td>
                  <td>2017-08-15</td>
                  <td>12</td>
                </tr>
                <tr>
                  <td>藏龙大瀑布</td>
                  <td>住宿</td>
                  <td>2017-08-15</td>
                  <td>12</td>
                </tr> -->
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="js/jquery-1.11.2.min.js"></script>
  <!-- jQuery -->
  <script type="text/javascript" src="js/templatemo-script.js"></script>
  <script>
    var getDataed = 0;
    var showArea = '';
    var nowCountryId = 1;
    $(".area").click(function () {
      x = $(this).index();
      showArea = x;
      showPoint();
      $(".one-area").eq(x).siblings(".one-area").css("display", "none");
      $(".one-area").eq(x).css("display", "block");
      $(".map-areaName").eq(x).siblings(".map-areaName").css("display", "none");
      $(".map-areaName").eq(x).css("display", "block");
    });

    $(function(){ 
      $.ajax({
        url : 'BackStage/showCountryInStage',
        type : 'GET',
        data : {
          countryId : 1
        },
        success : function(data){
          var jsonArray1 = JSON.parse(data).list1;
          var jsonArray2 = JSON.parse(data).list2;
          var jsonArray3 = JSON.parse(data).list3;
          var jsonArray4 = JSON.parse(data).list4;
          var jsonArray5 = JSON.parse(data).list5;
          var jsonArray3_2 = JSON.parse(data).list3_2;
          var jsonArray4_2 = JSON.parse(data).list4_2;
          var jsonArray5_2 = JSON.parse(data).list5_2;
          var outStr1 = "";
          var outStr2 = "本村已被" + jsonArray2 + "名用户收藏。";
          var outStr3 = "";
          $.each(jsonArray1,function(i,value){
            var jsonCell = value;
            outStr1 = jsonCell.name;
            outStr2 += "本村有" + jsonCell.sights + "个著名旅游景点，有" + jsonCell.restaurants + "家当地特色餐馆，有" + jsonCell.hotels + "家特色民宿";
          });
          $.each(jsonArray4,function(i,value){
            var oneStr = value;
            var outStr4 = jsonArray4_2[i];
            if(jsonArray4_2[i] == undefined){
              outStr4 = 0;
            }
            var addFormatTime = dateFormat(oneStr.addtime);
            if(oneStr.examine == "2"){
              outStr3 += "<tr><td>" + oneStr.name + "</td><td>景点</td><td>" + addFormatTime + "</td><td>" + outStr4 + "</td></tr>";
            }
          });
          $.each(jsonArray3,function(i,value){
            var oneStr = value;
            var outStr4 = jsonArray3_2[i];
            if(jsonArray3_2[i] == undefined){
              outStr4 = 0;
            }
            var addFormatTime = dateFormat(oneStr.addtime);
            if(oneStr.examine == "2"){
              outStr3 += "<tr><td>" + oneStr.name + "</td><td>餐馆</td><td>" + addFormatTime + "</td><td>" + outStr4 + "</td></tr>";
            }
          });
          $.each(jsonArray5,function(i,value){
            var oneStr = value;
            var outStr4 = jsonArray5_2[i];
            if(jsonArray5_2[i] == undefined){
              outStr4 = 0;
            }
            var addFormatTime = dateFormat(oneStr.addtime);
            if(oneStr.examine == "2"){
              outStr3 += "<tr><td>" + oneStr.hotelname + "</td><td>住宿</td><td>" + addFormatTime + "</td><td>" + outStr4 + "</td></tr>";
            }
          });
          $("#country_name").html(outStr1);//最后，打印出来
          $("#country_include").html(outStr2);
          $("#showSRH").html(outStr3);
        },
        error : function(){
          console.log("服务器被天狗吃掉了，获取数据失败~");
          // var data = '{"list5_2":[1,2],"list4":[{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","sname":"景点"},{"addtime":"Fri Jan 02 00:00:00 CST 2015","examine":"2","sname":"景点2"}],"list5":[{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","hotelname":"??"},{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","hotelname":"??2"}],"list2":2,"list3":[{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","rname":"餐馆"},{"addtime":"Sun Feb 01 00:00:00 CST 2015","examine":"1","rname":"餐馆2"}],"list1":[{"sights":14,"examine":"0","name":"高家堂村","restaurants":5,"hotels":"0"}],"list4_2":[1,2],"list3_2":[1,2]}';
        }
      });
    });

    $(".map-point").click(function () {
      x = $(this).index();
      if(x==0){
        nowCountryId = 4;
      } else if (x==1) {
        nowCountryId = 3
      } else if (x==2) {
        nowCountryId = 14
      } else if (x==3) {
        nowCountryId = 5
      } else if (x==4) {
        nowCountryId = 2
      } else if (x==5) {
        nowCountryId = 1
      } else if (x==6) {
        nowCountryId = 11
      } else if (x==7) {
        nowCountryId = 13
      };
      console.log( "这个村的"+nowCountryId);
      $.ajax({
        url : 'BackStage/showCountryInStage',
        type : 'GET',
        data : {
          countryId : nowCountryId
        },
        success : function(data){
          var jsonArray1 = JSON.parse(data).list1;
          var jsonArray2 = JSON.parse(data).list2;
          var jsonArray3 = JSON.parse(data).list3;
          var jsonArray4 = JSON.parse(data).list4;
          var jsonArray5 = JSON.parse(data).list5;
          var jsonArray3_2 = JSON.parse(data).list3_2;
          var jsonArray4_2 = JSON.parse(data).list4_2;
          var jsonArray5_2 = JSON.parse(data).list5_2;
          var outStr1 = "";
          var outStr2 = "本村已被" + jsonArray2 + "名用户收藏。";
          var outStr3 = "";
          $.each(jsonArray1,function(i,value){
            var jsonCell = value;
            outStr1 = jsonCell.name;
            outStr2 += "本村有" + jsonCell.sights + "个著名旅游景点，有" + jsonCell.restaurants + "家当地特色餐馆，有" + jsonCell.hotels + "家特色民宿";
          });
          $.each(jsonArray4,function(i,value){
            var oneStr = value;
            var outStr4 = jsonArray4_2[i];
            if(jsonArray4_2[i] == undefined){
              outStr4 = 0;
            }
            var addFormatTime = dateFormat(oneStr.addtime);
            if(oneStr.examine == "2"){
              outStr3 += "<tr><td>" + oneStr.name + "</td><td>景点</td><td>" + addFormatTime + "</td><td>" + outStr4 + "</td></tr>";
            }
          });
          $.each(jsonArray3,function(i,value){
            var oneStr = value;
            var outStr4 = jsonArray3_2[i];
            if(jsonArray3_2[i] == undefined){
              outStr4 = 0;
            }
            var addFormatTime = dateFormat(oneStr.addtime);
            if(oneStr.examine == "2"){
              outStr3 += "<tr><td>" + oneStr.name + "</td><td>餐馆</td><td>" + addFormatTime + "</td><td>" + outStr4 + "</td></tr>";
            }
          });
          $.each(jsonArray5,function(i,value){
            var oneStr = value;
            var outStr4 = jsonArray5_2[i];
            if(jsonArray5_2[i] == undefined){
              outStr4 = 0;
            }
            var addFormatTime = dateFormat(oneStr.addtime);
            if(oneStr.examine == "2"){
              outStr3 += "<tr><td>" + oneStr.hotelname + "</td><td>住宿</td><td>" + addFormatTime + "</td><td>" + outStr4 + "</td></tr>";
            }
          });
          $("#country_name").html(outStr1);//最后，打印出来
          $("#country_include").html(outStr2);
          $("#showSRH").html(outStr3);
        },
        error : function(){
          console.log("服务器被天狗吃掉了，获取数据失败~");
          <!-- var data = '{"list5_2":[11,2],"list4":[{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","sname":"景点"},{"addtime":"Fri Jan 02 00:00:00 CST 2015","examine":"2","sname":"景点2"}],"list5":[{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","hotelname":"??"},{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","hotelname":"??2"}],"list2":2,"list3":[{"addtime":"Thu Jan 01 00:00:00 CST 2015","examine":"2","rname":"餐馆"},{"addtime":"Sun Feb 01 00:00:00 CST 2015","examine":"1","rname":"餐馆2"}],"list1":[{"sights":14,"examine":"0","name":"高家堂村","restaurants":5,"hotels":"0"}],"list4_2":[21,2],"list3_2":[31,2]}'; -->
        }
      });
    });
    
    function showPoint() {
      $(".map-point").css("display", "none");
      if (showArea == 8) {
        $(".map-point").eq(6).css("display", "block");
      } else if (showArea == 6) {
        $(".map-point").eq(7).css("display", "block");
      } else if (showArea == 5) {
        $(".map-point").eq(0).css("display", "block");
        $(".map-point").eq(1).css("display", "block");
      } else if (showArea == 12) {
        $(".map-point").eq(2).css("display", "block");
      } else if (showArea == 13) {
        $(".map-point").eq(3).css("display", "block");
      } else if (showArea == 14) {
        $(".map-point").eq(4).css("display", "block");
        $(".map-point").eq(5).css("display", "block");
      }
    }

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

  </script>
</body>

</html>