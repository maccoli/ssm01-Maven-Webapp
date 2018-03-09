<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">

<head>
  <title>后台-首页</title>
  <meta charset="UTF-8">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/templatemo-style.css" rel="stylesheet">
  <style type="text/css"></style>
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
          <li><a href="home.jsp" class="active"><i class="fa fa-home fa-fw"></i>主页</a></li>
          <li><a href="countrysides.jsp"><i class="fa fa-map-marker fa-fw"></i>乡村分析</a></li>
          <li><a href="users.jsp"><i class="fa fa-users fa-fw"></i>用户分析</a></li>
          <li><a href="addCheck.jsp"><i class="fa fa-database fa-fw"></i>添加审核</a></li>
          <li><a href="tipCheck.jsp"><i class="fa fa-sliders fa-fw"></i>举报信息审核</a></li>
          <li><a href="loginOut.jsp"><i class="fa fa-eject fa-fw"></i>登入/登出</a></li>
        </ul>
      </nav>
    </div>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
      <div class="templatemo-content-contain/ler">
        <!-- 第一行 -->
        <div class="templatemo-flex-row flex-content-row margin-10">
          <div class="templatemo-content-widget white-bg col-2">
          	<div class="home-tip">
          		访问量
							<span class="label-notic" style="background: #D7425C;">月</span>
          	</div>
          	<div class="home-data-num">0,000</div>
          </div>
          <div class="templatemo-content-widget white-bg col-2">
          	<div class="home-tip">
          		已注册用户
							<span class="label-notic" style="background: #3275BB;">年</span>
          	</div>
          	<div class="home-data-num">0,000</div>
          </div>
          <div class="templatemo-content-widget white-bg col-2">
          	<div class="home-tip">
          		已注册乡村
							<span class="label-notic" style="background: #39ADB4;">年</span>
          	</div>
          	<div class="home-data-num">0,000</div>
          </div>
          <div class="templatemo-content-widget white-bg col-2">
          	<div class="home-tip">
          		活跃用户
							<span class="label-notic" style="background: #F17A54;">最近一个月</span>
          	</div>
          	<div class="home-data-num">0,000</div>
          </div>
        </div>
        <!-- 图表分析 -->
        <div class="templatemo-content-widget white-bg" style="margin-top:30px;">
          <h2 class="margin-bottom-10" style="display:block;margin-bottom:22px;font-size:18px;font-weight:600;">本站相关数据分析与统计</h2>
          <div class="panel panel-default no-border">
            <div class="panel-heading border-radius-10">
              <h2 class="table-font-family" style="font-size:16px;">本站访问量</h2>
            </div>
            <div class="panel-body">
              <div class="templatemo-flex-row flex-content-row ">
                <div class="col-1">
                  <div id="timeline_div" class="templatemo-chart table-font-family">
                    <div class="margin-right-15 templatemo-inline-block">
                      <input type="radio" name="radio1" id="r4" value="" checked>
                      <label for="r4" class="font-weight-400"><span></span>最近一周</label>
                    </div>
                    <div class="margin-right-15 templatemo-inline-block">
                      <input type="radio" name="radio1" id="r5" value="">
                      <label for="r5" class="font-weight-400"><span></span>最近一个月</label>
                    </div>
                    <div id="table-show-load" style="width: 900px;height:400px;"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="panel panel-default no-border">
            <div class="panel-heading border-radius-10">
              <h2 class="table-font-family" style="font-size:16px;">乡村访问量</h2>
            </div>
            <div class="panel-body">
              <div class="templatemo-flex-row flex-content-row">
                <div class="col-1">
                  <div id="timeline_div" class="templatemo-chart table-font-family">
                    <div class="margin-right-15 templatemo-inline-block">
                      <input type="radio" name="radio2" id="r1" value="" checked>
                      <label for="r1" class="font-weight-400"><span></span>最近一周</label>
                    </div>
                    <div class="margin-right-15 templatemo-inline-block">
                      <input type="radio" name="radio2" id="r2" value="">
                      <label for="r2" class="font-weight-400"><span></span>最近一个月</label>
                    </div>
                    <div id="table-show-country" style="width: 900px;height:400px;"></div>
                  </div>
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
  <script src="js/echarts.js"></script>
	<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('table-show-load'));
    var myChart2 = echarts.init(document.getElementById('table-show-country'));
  // 指定图表的配置项和数据
		var option1 = {
     //  title: {
     //    text: '折线图堆叠'
    	// },
    	tooltip: {
        trigger: 'axis'
    	},
    	legend: {
        data:['']
    	},
    	grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    	},
    	toolbox: {
        feature: {
					saveAsImage: {}
        }
    	},
    	xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['周一','周二','周三','周四','周五','周六','周日']
    	},
    	yAxis: {
        type: 'value'
    	},
    	series: [
        {
					name:'',
					type:'line',
					stack: '总量',
					data:[10, 12, 10, 13, 9, 20, 10]
        }
    	]
		};
		var option2 = {
     //  title: {
     //    text: '折线图堆叠'
    	// },
    	tooltip: {
        trigger: 'axis'
    	},
    	legend: {
        data:[]
    	},
    	grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    	},
    	toolbox: {
        feature: {
					saveAsImage: {}
        }
    	},
    	xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['1号','2号','3号','4号','5号','6号','7号','8号','9号','10号','11号','12号','13号','14号','15号','16号','17号','18号','19号','20号','21号','22号','23号','24号','25号','26号','27号','28号','29号','30号']
    	},
    	yAxis: {
        type: 'value'
    	},
    	series: [
        {
					name:'',
					type:'line',
					stack: '总量',
					data:[11, 14, 22, 13, 10, 8, 17, 20, 22, 13, 10, 19, 17, 14, 7, 13, 10, 5, 17, 14, 22, 14, 10, 13, 17, 14, 22, 13, 10, 8]
        }
    	]
		};
		var option3 = {
     //  title: {
     //    text: '折线图堆叠'
    	// },
    	tooltip: {
        trigger: 'axis'
    	},
    	legend: {
        data:['横山坞村','双一村','高家堂村','马家弄村','余村村','尚书干村','长林垓村','刘家塘村']
    	},
    	grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    	},
    	toolbox: {
        feature: {
					saveAsImage: {}
        }
    	},
    	xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['周一','周二','周三','周四','周五','周六','周日']
    	},
    	yAxis: {
        type: 'value'
    	},
    	series: [
        {
					name:'横山坞村',
					type:'line',
					stack: '总量1',
					data:[10, 12, 10, 13, 9, 20, 10]
        },
        {
					name:'双一村',
					type:'line',
					stack: '总量2',
					data:[11, 8, 4, 15, 11, 7, 17]
        },
        {
					name:'高家堂村',
					type:'line',
					stack: '总量3',
					data:[17, 10, 13, 7, 12, 8, 11]
        },
        {
					name:'马家弄村',
					type:'line',
					stack: '总量4',
					data:[14, 11, 7, 15, 7, 8, 10]
        },
        {
					name:'余村村',
					type:'line',
					stack: '总量5',
					data:[4, 12, 13, 17, 8, 16, 8]
        },
        {
					name:'尚书干村',
					type:'line',
					stack: '总量6',
					data:[15, 11, 14, 7, 10, 9, 13]
        },
        {
					name:'长林垓村',
					type:'line',
					stack: '总量7',
					data:[8, 7, 8, 10, 14, 13, 11]
        },
        {
					name:'刘家塘村',
					type:'line',
					stack: '总量8',
					data:[11, 17, 12, 11, 9, 14, 7]
        }
    	]
		};
		var option4 = {
     //  title: {
     //    text: '折线图堆叠'
    	// },
    	tooltip: {
        trigger: 'axis'
    	},
    	legend: {
        data:['横山坞村','双一村','高家堂村','马家弄村','余村村','尚书干村','长林垓村','刘家塘村']
    	},
    	grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    	},
    	toolbox: {
        feature: {
					saveAsImage: {}
        }
    	},
    	xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['1号','2号','3号','4号','5号','6号','7号','8号','9号','10号','11号','12号','13号','14号','15号','16号','17号','18号','19号','20号','21号','22号','23号','24号','25号','26号','27号','28号','29号','30号']
    	},
    	yAxis: {
        type: 'value'
    	},
    	series: [
        {
					name:'横山坞村',
					type:'line',
					stack: '总量1',
					data:[17, 14, 22 , 17, 14, 13, 10, 8, 10, 13, 17, 14, 17, 20, 22, 13, 10, 19, 17, 14, 7, 13, 10, 5, 22, 14, 22, 13, 10, 8]
        },
        {
					name:'双一村',
					type:'line',
					stack: '总量2',
					data:[10, 14, 20, 22, 13, 14, 22, 10, 19, 17, 14, 7, 13, 10, 5, 17, 22, 13, 10, 8, 17, 13, 14, 22, 14, 10, 17, 13, 10, 8]
        },
        {
					name:'高家堂村',
					type:'line',
					stack: '总量3',
					data:[14, 13, 10, 8, 17, 14, 14, 22, 22, 17, 14, 22, 14, 17, 20, 22, 13, 10, 19, 17, 14, 7, 13, 10, 5, 10, 13, 13, 10, 8]
        },
        {
					name:'马家弄村',
					type:'line',
					stack: '总量4',
					data:[13, 14, 22, 17, 14, 22, 14, 13, 10, 10, 19, 17, 14, 7, 13, 10, 5, 10, 13, 17, 14, 8, 17, 20, 22, 13, 22, 13, 10, 8]
        },
        {
					name:'余村村',
					type:'line',
					stack: '总量5',
					data:[11, 14, 22, 13, 10, 13, 10, 19, 5, 17, 14, 22, 14, 17, 14, 7, 13, 10, 10, 13, 17, 14, 22, 8, 17, 20, 22, 13, 10, 8]
        },
        {
					name:'尚书干村',
					type:'line',
					stack: '总量6',
					data:[15, 14, 22, 17, 14, 17, 14, 22, 13, 13, 10, 8, 17, 22, 14, 10, 13, 20, 22, 13, 10, 19, 17, 14, 7, 13, 10, 5, 10, 8]
        },
        {
					name:'长林垓村',
					type:'line',
					stack: '总量7',
					data:[8, 17, 20, 22, 11, 14, 14, 22, 14, 10, 22, 13, 10, 13, 10, 19, 17, 17, 14, 22, 13, 14, 7, 13, 10, 5, 17, 13, 10, 8]
        },
        {
					name:'刘家塘村',
					type:'line',
					stack: '总量8',
					data:[22, 14, 22, 17, 14, 10, 13, 17, 22, 14, 13, 10, 8, 17, 20, 22, 13, 10, 19, 17, 14, 7, 13, 10, 5, 14, 22, 13, 10, 8]
        }
    	]
		};
	// 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
    myChart2.setOption(option3);

    $("#r4").click(function (){
    	myChart1.setOption(option1);
    });
    $("#r5").click(function (){
    	myChart1.setOption(option2);
    });
    $("#r1").click(function (){
    	myChart2.setOption(option3);
    });
    $("#r2").click(function (){
    	myChart2.setOption(option4);
    });

  // 修改上部分数字
    var num1 = '0';
    var num2 = '0';
    var num3 = '0';
    var num4 = '0';

    function numChange (num, objStr, whoNo, secendLimit) {
			var numI = 0;
			var indexNum = 0;
			var threeNum = '000';
			const self = this;
			if (num <= parseInt((this[objStr]).replace(',', ''))) {
				return;
			}
			var timer = setInterval(function () {
				/* 获取数据的值 字符串转为数字 */
				var nowNum = parseInt((self[objStr]).replace(',', ''))
				if (numI < num) {
					indexNum = nowNum + 1;
					if (indexNum >= 1000) {
						var n = indexNum - Math.floor(indexNum / 1000) * 1000
						if (n < 10) {
							threeNum = '00' + n;
						} else if (n < 100) {
							threeNum = '0' + n;
						} else if (n < 1000) {
							threeNum = '' + n;
						}
						self[objStr] = (Math.floor(indexNum / 1000)) + ',' + threeNum;
					} else {
						if (indexNum < 10) {
							threeNum = '00' + indexNum;
						} else if (indexNum < 100) {
							threeNum = '0' + indexNum;
						} else if (indexNum < 1000) {
							threeNum = '' + indexNum;
						}
						self[objStr] = '0,' + threeNum;
					}
					numI++;
				}
				if (indexNum === num) {
					clearInterval(timer);
				}
        $(".home-data-num").eq(whoNo).html(self[objStr]);
			}, secendLimit)
		};

    $(function(){
      numChange (1077, "num1", 0, 1);
      numChange (129, "num2", 1, 25);
      numChange (11, "num3", 2, 100);
      numChange (54, "num4", 3, 50);
    });



	</script>
</body>

</html>