<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">

<head>
  <title>后台-添加审核</title>
  <meta charset="UTF-8">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/templatemo-style.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link rel="shortcut icon" href="static/favicon.ico" mce_href="favicon.ico" type="image/x-icon">
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
          <li><a href="users.jsp"><i class="fa fa-users fa-fw"></i>用户分析</a></li>
          <li><a href="addCheck.jsp" class="active"><i class="fa fa-database fa-fw"></i>添加审核</a></li>
          <li><a href="tipCheck.jsp"><i class="fa fa-sliders fa-fw"></i>举报信息审核</a></li>
          <li><a href="loginOut.jsp"><i class="fa fa-eject fa-fw"></i>登入/登出</a></li>
        </ul>
      </nav>
    </div>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
      <!-- choose -->
      <div class="templatemo-top-nav-container">
        <div class="row">
          <nav class="templatemo-top-nav col-lg-12 col-md-12">
            <ul class="text-uppercase">
              <li class="active">乡村添加</li>
              <li>景点添加<!-- <span class="add-news-num">1</span> --></li>
              <li>餐馆添加</li>
              <li>住宿添加</li>
            </ul>
          </nav>
        </div>
      </div>
      <!-- 乡村添加 -->
      <div class="templatemo-content-container add-message-tab" style="display:block;">
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td style="width:25%;">名称</td>
                  <td style="width:22%;">BY</td>
                  <td style="width:15%;">添加时间</td>
                  <td style="width:23%;">操作</td>
                  <td style="width:15%;">状态</td>
                </tr>
              </thead>
              <tbody id="country_add">
                <!-- <tr>
                  <td>乡村添加</td>
                  <td>Silence12344</td>
                  <td>2017-08-14</td>
                  <td>
                    <input type="button" name="" class="table-input-view country-infor-view" value="查看">
                    <input type="button" name="" class="table-input-view" value="提交审查结果">
                  </td>
                  <td>
                    <select class="table-select">
                      <option value="0">未处理</option>
                      <option value="1">未通过</option>
                      <option value="2">通过</option>
                    </select>
                  </td>
                </tr> -->
              </tbody>
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
      </div>
      <div class="templatemo-content-container infor-of-table" style="display:none;">
        <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden">
            <div class="col-1 templatemo-overflow-hidden">
              <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-md-12" id="add_country_infor">
                  </div>
                </div>                
              </div>
            </div>
        </div>
      </div>
      <!-- 景点添加 -->
      <div class="templatemo-content-container add-message-tab" style="display:none;">
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td style="width:25%;">名称</td>
                  <td style="width:22%;">BY</td>
                  <td style="width:15%;">添加时间</td>
                  <td style="width:23%;">操作</td>
                  <td style="width:15%;">状态</td>
                </tr>
              </thead>
              <tbody id="spot_add">
              </tbody>
            </table>
          </div>
        </div>
        <!-- 翻页 -->
        <div class="pagination-wrap">
          <ul class="pagination">
            <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li>
              <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="templatemo-content-container infor-of-table" style="display:none;">
        <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden">
            <div class="col-1 templatemo-overflow-hidden">
              <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-md-12" id="add_spot_infor">
                  </div>
                </div>                
              </div>
            </div>
        </div>
      </div>  
      <!-- 餐馆添加 -->
      <div class="templatemo-content-container add-message-tab" style="display:none;">
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td style="width:25%;">名称</td>
                  <td style="width:22%;">BY</td>
                  <td style="width:15%;">添加时间</td>
                  <td style="width:23%;">操作</td>
                  <td style="width:15%;">状态</td>
                </tr>
              </thead>
              <tbody id="restaurant_add">
              </tbody>
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
      </div>
      <div class="templatemo-content-container infor-of-table" style="display:none;">
        <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden">
            <div class="col-1 templatemo-overflow-hidden">
              <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-md-12" id="add_restaurant_infor">
                  </div>
                </div>                
              </div>
            </div>
        </div>
      </div>  
      <!-- 住宿添加 -->
      <div class="templatemo-content-container add-message-tab" style="display:none;">
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td style="width:25%;">名称</td>
                  <td style="width:22%;">BY</td>
                  <td style="width:15%;">添加时间</td>
                  <td style="width:23%;">操作</td>
                  <td style="width:15%;">状态</td>
                </tr>
              </thead>
              <tbody id="hotel_add">
              </tbody>
            </table>
          </div>
        </div>
        <!-- 翻页 -->
        <div class="pagination-wrap">
          <ul class="pagination">
            <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li>
              <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="templatemo-content-container infor-of-table" style="display:none;">
        <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden">
            <div class="col-1 templatemo-overflow-hidden">
              <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-md-12" id="add_hotel_infor">
                  </div>
                </div>                
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
      month = (String(month).length < 2) ? '0' + month : month;
      day = (String(day).length < 2) ? '0' + day : day;
      return year + '-' + month + '-' + day;
    }

    $(".text-uppercase li").click(function () {
      x = $(this).index();
      $(this).siblings(".text-uppercase li").removeClass("active");
      $(this).addClass("active");
      $(".add-message-tab").eq(x).siblings(".add-message-tab").css("display", "none");
      $(".add-message-tab").eq(x).css("display", "block");
      if(x == 0){
        $.ajax({
          url : 'AddExamine/showExamine',
          type : 'GET',
          data : {
            pageNo : 1 //表示第一页
          },
          success : function(data){
            var jsonArray = JSON.parse(data).list;
            var outStr1 = "";
            var outStr2 = "";
            var outStr3 = "";
            $.each(jsonArray,function(i,value){
              var jsonCell = value;
              var select1 = "";
              var select2 = "";
              var select0 = "";
              var timeFormate = dateFormat(jsonCell.addtime);
              if(jsonCell.examine == "0"){
                select0 = "selected";
              } else if(jsonCell.examine == "1"){
                select1 = "selected";
              } else {
                select2 = "selected";
              }
              outStr1 += "<tr><td class='addCName'>" + jsonCell.name + "</td><td>" + jsonCell.username + "</td><td>" + timeFormate + "</td><td><input type='button' name='' class='table-input-view country-infor-view' value='查看'><input type='button' name='' class='table-input-view country-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select country-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
            });
            $("#country_add").html(outStr1);
          },
          error : function(){
            console.log("服务器被天狗吃掉了,获取数据失败~");
            // 0 未处理  1 未通过  2 通过
            var data = '{"list":[{"name":"长林垓村1","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"长林垓村2","username":"某某某","addtime":"2017-08-14","examine":"1"},{"name":"长林垓村3","username":"某某某","addtime":"2017-08-14","examine":"2"},{"name":"长林垓村4","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"长林垓村5","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"长林垓村6","username":"某某某","addtime":"2017-08-14","examine":"0"}]}';
            var jsonArray = JSON.parse(data).list;
            var outStr1 = "";
            var outStr2 = "";
            var outStr3 = "";
            $.each(jsonArray,function(i,value){
              var jsonCell = value;
              var select1 = "";
              var select2 = "";
              var select0 = "";
              if(jsonCell.examine == "0"){
                select0 = "selected";
              } else if(jsonCell.examine == "1"){
                select1 = "selected";
              } else {
                select2 = "selected";
              }
              outStr1 += "<tr><td class='addCName'>" + jsonCell.name + "</td><td>" + jsonCell.username + "</td><td>" + jsonCell.addtime + "</td><td><input type='button' name='' class='table-input-view country-infor-view' value='查看'><input type='button' name='' class='table-input-view country-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select country-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
            });
            $("#country_add").html(outStr1);
          }
        });
      } else if(x == 1){
        $.ajax({
          url : 'AddExamine/showExamines',
          type : 'GET',
          data : {
            pageNo : 1 //表示第一页
          },
          success : function(data){
            var jsonArray = JSON.parse(data).list;
            var outStr1 = "";
            var outStr2 = "";
            var outStr3 = "";
            $.each(jsonArray,function(i,value){
              var jsonCell = value;
              var select1 = "";
              var select2 = "";
              var select0 = "";
              var timeFormate = dateFormat(jsonCell.addtime);
              if(jsonCell.examine == "0"){
                select0 = "selected";
              } else if(jsonCell.examine == "1"){
                select1 = "selected";
              } else {
                select2 = "selected";
              }
              outStr1 += "<tr><td class='addSName'>" + jsonCell.name + "</td><td>" + jsonCell.username + "</td><td>" + timeFormate + "</td><td><input type='button' name='' class='table-input-view spot-infor-view' value='查看'><input type='button' name='' class='table-input-view spot-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select spot-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
            });
            $("#spot_add").html(outStr1);
          },
          error : function(){
            console.log("服务器被天狗吃掉了,获取数据失败~");
            
          }
        });
      } else if(x == 2){
        $.ajax({
          url : 'AddExamine/showExaminer',
          type : 'GET',
          data : {
            pageNo : 1 //表示第一页
          },
          success : function(data){
            var jsonArray = JSON.parse(data).list;
            var outStr1 = "";
            var outStr2 = "";
            var outStr3 = "";
            $.each(jsonArray,function(i,value){
              var jsonCell = value;
              var select1 = "";
              var select2 = "";
              var select0 = "";
              var timeFormate = dateFormat(jsonCell.addtime);
              if(jsonCell.examine == "0"){
                select0 = "selected";
              } else if(jsonCell.examine == "1"){
                select1 = "selected";
              } else {
                select2 = "selected";
              }
              outStr1 += "<tr><td class='addRName'>" + jsonCell.name + "</td><td>" + jsonCell.username + "</td><td>" + timeFormate + "</td><td><input type='button' name='' class='table-input-view restaurant-infor-view' value='查看'><input type='button' name='' class='table-input-view restaurant-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select restaurant-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
            });
            $("#restaurant_add").html(outStr1);
          },
          error : function(){
            console.log("服务器被天狗吃掉了,获取数据失败~");
            // 0 未处理  1 未通过  2 通过
            var data = '{"list":[{"name":"餐馆","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"餐馆","username":"某某某","addtime":"2017-08-14","examine":"1"},{"name":"餐馆","username":"某某某","addtime":"2017-08-14","examine":"2"},{"name":"餐馆","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"餐馆","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"餐馆","username":"某某某","addtime":"2017-08-14","examine":"0"}]}';
            var jsonArray = JSON.parse(data).list;
            var outStr1 = "";
            var outStr2 = "";
            var outStr3 = "";
            $.each(jsonArray,function(i,value){
              var jsonCell = value;
              var select1 = "";
              var select2 = "";
              var select0 = "";
              if(jsonCell.examine == "0"){
                select0 = "selected";
              } else if(jsonCell.examine == "1"){
                select1 = "selected";
              } else {
                select2 = "selected";
              }
              outStr1 += "<tr><td class='addRName'>" + jsonCell.name + "</td><td>" + jsonCell.username + "</td><td>" + jsonCell.addtime + "</td><td><input type='button' name='' class='table-input-view restaurant-infor-view' value='查看'><input type='button' name='' class='table-input-view restaurant-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select restaurant-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
            });
            $("#restaurant_add").html(outStr1);
          }
        });
      } else {
        $.ajax({
          url : 'AddExamine/showExamineh',
          type : 'GET',
          data : {
            pageNo : 1 //表示第一页
          },
          success : function(data){
            var jsonArray = JSON.parse(data).list;
            var outStr1 = "";
            var outStr2 = "";
            var outStr3 = "";
            $.each(jsonArray,function(i,value){
              var jsonCell = value;
              var select1 = "";
              var select2 = "";
              var select0 = "";
              var timeFormate = dateFormat(jsonCell.addtime);
              if(jsonCell.examine == "0"){
                select0 = "selected";
              } else if(jsonCell.examine == "1"){
                select1 = "selected";
              } else {
                select2 = "selected";
              }
              outStr1 += "<tr><td class='addHName'>" + jsonCell.hotelname + "</td><td>" + jsonCell.username + "</td><td>" + timeFormate + "</td><td><input type='button' name='' class='table-input-view hotel-infor-view' value='查看'><input type='button' name='' class='table-input-view hotel-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select hotel-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
            });
            $("#hotel_add").html(outStr1);
          },
          error : function(){
            console.log("服务器被天狗吃掉了,获取数据失败~");
            // 0 未处理  1 未通过  2 通过
            var data = '{"list":[{"name":"住宿","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"住宿","username":"某某某","addtime":"2017-08-14","examine":"1"},{"name":"住宿","username":"某某某","addtime":"2017-08-14","examine":"2"},{"name":"住宿","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"住宿","username":"某某某","addtime":"2017-08-14","examine":"0"},{"name":"住宿","username":"某某某","addtime":"2017-08-14","examine":"0"}]}';
            var jsonArray = JSON.parse(data).list;
            var outStr1 = "";
            var outStr2 = "";
            var outStr3 = "";
            $.each(jsonArray,function(i,value){
              var jsonCell = value;
              var select1 = "";
              var select2 = "";
              var select0 = "";
              if(jsonCell.examine == "0"){
                select0 = "selected";
              } else if(jsonCell.examine == "1"){
                select1 = "selected";
              } else {
                select2 = "selected";
              }
              outStr1 += "<tr><td class='addHName'>" + jsonCell.name + "</td><td>" + jsonCell.username + "</td><td>" + jsonCell.addtime + "</td><td><input type='button' name='' class='table-input-view hotel-infor-view' value='查看'><input type='button' name='' class='table-input-view hotel-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select hotel-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
            });
            $("#hotel_add").html(outStr1);
          }
        });
      }
    });
    // 回退
    $("body").on("click",".back-icon",function() {
      $(".infor-of-table").eq(0).css("display", "none");
      $(".add-message-tab").eq(0).css("display", "block");
    });
    $("body").on("click",".back-icon-spot",function() {
      $(".infor-of-table").eq(1).css("display", "none");
      $(".add-message-tab").eq(1).css("display", "block");
    });
    $("body").on("click",".back-icon-res",function() {
      $(".infor-of-table").eq(2).css("display", "none");
      $(".add-message-tab").eq(2).css("display", "block");
    });
    $("body").on("click",".back-icon-hotel",function() {
      $(".infor-of-table").eq(3).css("display", "none");
      $(".add-message-tab").eq(3).css("display", "block");
    });

    // 提交审核
    $("body").on("click",".country-result-sub",function() {
      x = $(this).index(".country-result-sub");
      $(this).val("已提交");
      var thisCN = $(".addCName").eq(x).html();
      var thisState = $(".country-select").eq(x).val();
      $.ajax({
        url : 'AddExamine/updateExaminec',
        type : 'GET',
        data : {
          name : thisCN,
          examine : thisState
        },
        success : function(){
          console.log("成功更新数据~")
        },
        error : function(){
          console.log("服务器连接失败，数据更新失败")
        }
      })
    });
    $("body").on("click",".spot-result-sub",function() {
      x = $(this).index(".spot-result-sub");
      $(this).val("已提交");
      var thisSN = $(".addSName").eq(x).html();
      var thisState = $(".spot-select").eq(x).val();
      $.ajax({
        url : 'AddExamine/updateExamines',
        type : 'GET',
        data : {
          name : thisSN,
          examine : thisState
        },
        success : function(){
          console.log("成功更新数据~")
        },
        error : function(){
          console.log("服务器连接失败，数据更新失败")
        }
      })
    });
    $("body").on("click",".restaurant-result-sub",function() {
      x = $(this).index(".restaurant-result-sub");
      $(this).val("已提交");
      var thisRN = $(".addRName").eq(x).html();
      var thisState = $(".restaurant-select").eq(x).val();
      $.ajax({
        url : 'AddExamine/updateExaminer',
        type : 'GET',
        data : {
          name : thisRN,
          examine : thisState
        },
        success : function(){
          console.log("成功更新数据~")
        },
        error : function(){
          console.log("服务器连接失败，数据更新失败")
        }
      })
    });
    $("body").on("click",".hotel-result-sub",function() {
      x = $(this).index(".hotel-result-sub");
      $(this).val("已提交");
      var thisHN = $(".addHName").eq(x).html();
      var thisState = $(".hotel-select").eq(x).val();
      $.ajax({
        url : 'AddExamine/updateExamineh',
        type : 'GET',
        data : {
          hotelname : thisHN,
          examine : thisState
        },
        success : function(){
          console.log("成功更新数据~")
        },
        error : function(){
          console.log("服务器连接失败，数据更新失败")
        }
      })
    });

    // 查看添加的乡村
    $("body").on("click",".country-infor-view",function(){
      x = $(this).index(".country-infor-view");
      // console.log(x);
      var thisCN = $(".addCName").eq(x).html();
      // console.log(thisCN);
      $(".add-message-tab").eq(0).css("display", "none");
      $(".infor-of-table").eq(0).css("display", "block");
      $.ajax({
        url : 'AddExamine/showsExamine',
        type : 'GET',
        data : {
          name : thisCN
        },
        success : function(data){
          var jsonArray = JSON.parse(data).list;
          var jsonArray1 = JSON.parse(data).list1;
          var jsonArray2 = JSON.parse(data).list2;
          var jsonArray3 = JSON.parse(data).list3;
          var outStr = "";
          var outStr1 = "";
          var outStr2 = "";
          var outStr3 = "";
          var outStr4 = "";
          $.each(jsonArray3,function(i,value){
            var oneTC = value;
            outStr1 += "<div class='country-special-box'><img src='" + oneTC.src + "'><span>" + oneTC.name + "</span></div>"
          });
          $.each(jsonArray1,function(i,value){
            var oneZP = value;
            outStr2 += "<img src='img/countryside/otherPic/" + oneZP + "'>";
          });
          $.each(jsonArray2,function(i,value){
            var oneSP = value;
            outStr3 += "<div class='li-context-video-box' style='margin-bottom:25px;'><video width='100%' height='100%' controls><source src='img/countryside/videos/" + oneSP + "'  type='video/mp4'></video></div>";
          });
          if(jsonArray2.length > 0) {
            outStr4 = "<ul class='infor-ul clear'><li class='ul-left-title table-font-family'>视&emsp;&emsp;频：</li><li class='ul-right-context'>" + outStr3 + "</li></ul>"
          }
          $.each(jsonArray,function(i,value){
            var jsonCell = value;
            outStr = "<h2 class='text-center table-font-family'><span class='back-icon fa fa-arrow-circle-left fa-fw'></span>" + jsonCell.name + "</h2><div id='pie_chart_div' class='templatemo-chart'><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>简&emsp;&emsp;介：</li><li class='ul-right-context table-font-family'>" + jsonCell.introduce + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>隶&emsp;&emsp;属：</li><li class='ul-right-context table-font-family'><span  class='table-font-family'>" + jsonCell.location + "</span></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>封&emsp;&emsp;面：</li><li class='ul-right-context'><div class='li-context-img-box'><img src='img/countryside/mainPic/" + jsonCell.mianpic + "' class='img-auto'></div></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>照&ensp;片&ensp;集：</li><li class='ul-right-context'><div class='li-context-imgs-box'>" + outStr2 + "</div></li></ul>" + outStr4 + "<ul class='infor-ul clear'><li class='ul-left-title table-font-family'>文&emsp;&emsp;化：</li><li class='ul-right-context table-font-family'><a href='#' style='text-decoration:underline'>" + jsonCell.culture + "</a></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>活&emsp;&emsp;动：</li><li class='ul-right-context table-font-family'><a href='#' style='text-decoration:underline'>" + jsonCell.activities + "</a></li></ul></div>"
          });
          $("#add_country_infor").html(outStr);
        },
        error : function(){
          console.log("服务器被天狗吃掉了,获取数据失败~");
          // 0 未处理  1 未通过  2 通过
        }
      });
    });
    // 查看添加的景点
    $("body").on("click",".spot-infor-view",function(){
      x = $(this).index(".spot-infor-view");
      // console.log(x);
      var thisCN = $(".addSName").eq(x).html();
      console.log(thisCN);
      $(".add-message-tab").eq(1).css("display", "none");
      $(".infor-of-table").eq(1).css("display", "block");
      $.ajax({
        url : 'AddExamine/showsSExamine',
        type : 'GET',
        data : {
          sname : thisCN
        },
        success : function(data){
          var jsonArray = JSON.parse(data).list;
          console.log(jsonArray);
          var outStr = "";
          var outStr1 = "";
          var outStr2 = jsonArray[0].pices;
          if (outStr2 !== ''){
            array = outStr2.split(';');
          } else {
            array = [];
          }
          var zpjAll = array;
          $.each(jsonArray,function(i,value){
            var jsonCell = value;
            var outStr3 = "<ul class='infor-ul clear'><li class='ul-left-title table-font-family'>视&emsp;&emsp;频：</li><li class='ul-right-context'><div class='li-context-video-box'><video width='100%' height='100%' controls><source src='" + jsonCell.video + "'  type='video/mp4'></video></div></li></ul>";
            if(jsonCell.video == undefined || jsonCell.video == null || jsonCell.video == 0){
              outStr3 = "";
            }
            $.each(zpjAll,function(i,value){
              var oneZP = value;
              outStr1 += "<img src='img/scienspot/otherPic/" + oneZP + "'>";
            });
            outStr = "<h2 class='text-center table-font-family'><span class='back-icon-spot fa fa-arrow-circle-left fa-fw'></span>" + jsonCell.name + "</h2><div id='pie_chart_div' class='templatemo-chart'><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>简&emsp;&emsp;介：</li><li class='ul-right-context table-font-family'>" + jsonCell.synosis + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>隶&emsp;&emsp;属：</li><li class='ul-right-context table-font-family'><span  class='table-font-family'>" + jsonCell.location + "</span></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>门&emsp;&emsp;票：</li><li class='ul-right-context table-font-family'><span  class='table-font-family'>" + jsonCell.price + "</span> RMB/人</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>联系方式：</li><li class='ul-right-context table-font-family'>" + jsonCell.cinformation + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>详细地址：</li><li class='ul-right-context table-font-family'>" + jsonCell.address + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>封&emsp;&emsp;面：</li><li class='ul-right-context'><div class='li-context-img-box'><img src='img/scienspot/cover/" + jsonCell.cover + "' class='img-auto'></div></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>照&ensp;片&ensp;集：</li><li class='ul-right-context'><div class='li-context-imgs-box'>" + outStr1 + "</div></li></ul>" + outStr3 + "</div>";
          });
          $("#add_spot_infor").html(outStr);
        },
        error : function(){
          console.log("服务器被天狗吃掉了,获取数据失败~");
        }
      });
    });
    // 查看添加的餐馆
    $("body").on("click",".restaurant-infor-view",function(){
      x = $(this).index(".restaurant-infor-view");
      // console.log(x);
      var thisRN = $(".addRName").eq(x).html();
      console.log(thisRN);
      $(".add-message-tab").eq(2).css("display", "none");
      $(".infor-of-table").eq(2).css("display", "block");
      $.ajax({
        url : 'AddExamine/showsRExamine',
        type : 'GET',
        data : {
          rname : thisRN
        },
        success : function(data){
          var jsonArray = JSON.parse(data).list;
          var outStr = "";
          var outStr1 = "";
          var outStr2 = jsonArray[0].pices;
          if (outStr2 !== ''){
            array = outStr2.split(';');
          } else {
            array = [];
          }
          var zpjAll = array;
          $.each(jsonArray,function(i,value){
            var jsonCell = value;
            var outStr3 = "<ul class='infor-ul clear'><li class='ul-left-title table-font-family'>视&emsp;&emsp;频：</li><li class='ul-right-context'><div class='li-context-video-box'><video width='100%' height='100%' controls><source src='" + jsonCell.video + "'  type='video/mp4'></video></div></li></ul>";
            if(jsonCell.video == undefined || jsonCell.video == null || jsonCell.video == 0){
              outStr3 = "";
            }
            $.each(zpjAll,function(i,value){
              var oneZP = value;
              outStr1 += "<img src='img/restaurant/otherPic/" + oneZP + "'>";
            });
            outStr = "<h2 class='text-center table-font-family'><span class='back-icon-res fa fa-arrow-circle-left fa-fw'></span>" + jsonCell.name + "</h2><div id='pie_chart_div' class='templatemo-chart'><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>简&emsp;&emsp;介：</li><li class='ul-right-context table-font-family'>" + jsonCell.synopsis + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>隶&emsp;&emsp;属：</li><li class='ul-right-context table-font-family'><span  class='table-font-family'>" + jsonCell.location + "</span></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>门&emsp;&emsp;票：</li><li class='ul-right-context table-font-family'><span  class='table-font-family'>" + jsonCell.perprice + "</span> RMB/人</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>联系方式：</li><li class='ul-right-context table-font-family'>" + jsonCell.cinformation + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>详细地址：</li><li class='ul-right-context table-font-family'>" + jsonCell.address + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>封&emsp;&emsp;面：</li><li class='ul-right-context'><div class='li-context-img-box'><img src='img/restaurant/cover/" + jsonCell.cover + "' class='img-auto'></div></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>照&ensp;片&ensp;集：</li><li class='ul-right-context'><div class='li-context-imgs-box'>" + outStr1 + "</div></li></ul>" + outStr3 + "</div>";
          });
          $("#add_restaurant_infor").html(outStr);
        },
        error : function(){
          console.log("服务器被天狗吃掉了,获取数据失败~");
          // 0 未处理  1 未通过  2 通过
        }
      });
    });
    // 查看添加的住宿
    $("body").on("click",".hotel-infor-view",function(){
      x = $(this).index(".hotel-infor-view");
      // console.log(x);
      var thisHN = $(".addHName").eq(x).html();
      console.log(thisHN);
      $(".add-message-tab").eq(3).css("display", "none");
      $(".infor-of-table").eq(3).css("display", "block");
      $.ajax({
        url : 'AddExamine/showsHExamine',
        type : 'GET',
        data : {
          hname : thisHN
        },
        success : function(data){
          var jsonArray = JSON.parse(data).list;
          var outStr = "";
          var outStr1 = "";
          var outStr2 = jsonArray[0].pice;
          if (outStr2 !== ''){
            array = outStr2.split(';');
          } else {
            array = [];
          }
          var zpjAll = array;
          $.each(jsonArray,function(i,value){
            var jsonCell = value;
            var outStr3 = "<ul class='infor-ul clear'><li class='ul-left-title table-font-family'>视&emsp;&emsp;频：</li><li class='ul-right-context'><div class='li-context-video-box'><video width='100%' height='100%' controls><source src='" + jsonCell.video + "'  type='video/mp4'></video></div></li></ul>";
            if(jsonCell.video == undefined || jsonCell.video == null || jsonCell.video == 0){
              outStr3 = "";
            }
            $.each(zpjAll,function(i,value){
              var oneZP = value;
              outStr1 += "<img src='img/hotel/otherPic/" + oneZP + "'>";
            });
            outStr = "<h2 class='text-center table-font-family'><span class='back-icon-hotel fa fa-arrow-circle-left fa-fw'></span>" + jsonCell.hotelname + "</h2><div id='pie_chart_div' class='templatemo-chart'><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>简&emsp;&emsp;介：</li><li class='ul-right-context table-font-family'>" + jsonCell.introduce + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>隶&emsp;&emsp;属：</li><li class='ul-right-context table-font-family'><span  class='table-font-family'>" + jsonCell.location + "</span></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>门&emsp;&emsp;票：</li><li class='ul-right-context table-font-family'><span  class='table-font-family'>" + jsonCell.lowprice + "</span> RMB/人</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>联系方式：</li><li class='ul-right-context table-font-family'>" + jsonCell.phone + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>详细地址：</li><li class='ul-right-context table-font-family'>" + jsonCell.detaillocation + "</li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>封&emsp;&emsp;面：</li><li class='ul-right-context'><div class='li-context-img-box'><img src='img/hotel/cover/" + jsonCell.mainpic + "' class='img-auto'></div></li></ul><ul class='infor-ul clear'><li class='ul-left-title table-font-family'>照&ensp;片&ensp;集：</li><li class='ul-right-context'><div class='li-context-imgs-box'>" + outStr1 + "</div></li></ul>" + outStr3 + "</div>";
          });
          $("#add_hotel_infor").html(outStr);
        },
        error : function(){
          console.log("服务器被天狗吃掉了,获取数据失败~");
          // 0 未处理  1 未通过  2 通过
        }
      });
    });

    $(function(){ 
      $.ajax({
        url : 'AddExamine/showExamine',
        type : 'GET',
        data : {
          inforType : "country",
          pageNo : 1 //表示第一页
        },
        success : function(data){
          var jsonArray = JSON.parse(data).list;
          var outStr1 = "";
          var outStr2 = "";
          var outStr3 = "";
          $.each(jsonArray,function(i,value){
            var jsonCell = value;
            var select1 = "";
            var select2 = "";
            var select0 = "";
            var timeFormate = dateFormat(jsonCell.addtime);
            if(jsonCell.examine == "0"){
              select0 = "selected";
            } else if(jsonCell.examine == "1"){
              select1 = "selected";
            } else {
              select2 = "selected";
            }
            outStr1 += "<tr><td class='addCName'>" + jsonCell.name + "</td><td>" + jsonCell.username + "</td><td>" + timeFormate + "</td><td><input type='button' name='' class='table-input-view country-infor-view' value='查看'><input type='button' name='' class='table-input-view country-result-sub' value='提交审查结果' style='margin-left:10px;outline:none;'></td><td><select class='table-select country-select'><option value='0' " + select0 + ">未处理</option><option value='1' " + select1 + ">未通过</option><option value='2' " + select2 + ">通过</option></select></td></tr>";
          });
          $("#country_add").html(outStr1);
        },
        error : function(){
          console.log("服务器被天狗吃掉了,获取数据失败~");
          // 0 未处理  1 未通过  2 通过
        }
      });
    });


  </script>
</body>

</html>