<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<link rel="shortcut icon" type="image/png" href="assets/images/icon/favicon.ico">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/metisMenu.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/slicknav.min.css">
    <!-- amchart css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <!-- others css -->
    <link rel="stylesheet" href="assets/css/typography.css">
    <link rel="stylesheet" href="assets/css/default-css.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/responsive.css">
    
    <style>
    
.blink {
  animation: blinker 1s cubic-bezier(.5, 0, 1, 1) infinite alternate;  
}
@keyframes blinker {  
  from { opacity: 1; }
  to { opacity: 0; }
}
    
    
</style>
    
    <!-- modernizr css -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>

<div class="row">
<div class="col-lg-8">
<p id="code"></p>

	<span class="badge"><i class="fa fa-circle text-success" style="color:green;"  id="blink_yellow"></i> 
<i class="fa fa-circle text-warning" style="color:red;" id="blink_red"></i> </span>
               
</div>
                    <!-- seo fact area start -->
                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col-md-6 mt-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg1">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-thumb-up"></i> Total Citizen Count</div>
                                            <p id="count_vehicle"></p>
                                        </div>
                                        <canvas id="seolinechart1" height="20"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mt-md-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg2">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-share"></i>Total Politician count</div>
                                            
                                             <p id="poli_count"></p>
                                        </div>
                                        <canvas id="seolinechart1" height="20"></canvas>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-md-6 mt-md-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg3">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-share"></i>Total Active Login</div>
                                           <p id="active_login"></p>
                                        </div>
                                         <canvas id="seolinechart1" height="20"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mt-md-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg3">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-share"></i>Total Deactive Login</div>
                                           <p id="deactive_login"></p>
                                        </div>
                                         <canvas id="seolinechart1" height="20"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mt-md-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg3">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-share"></i>Total Admin Count</div>
                                           <p id="web_admin_login"></p>
                                        </div>
                                         <canvas id="seolinechart1" height="20"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mt-md-5 mb-3">
                                <div class="card">
                                    <div class="seo-fact sbg3">
                                        <div class="p-4 d-flex justify-content-between align-items-center">
                                            <div class="seofct-icon"><i class="ti-share"></i>Total Mobile Count</div>
                                           <p id="mobile_login"></p>
                                        </div>
                                         <canvas id="seolinechart1" height="20"></canvas>
                                    </div>
                                </div>
                            </div>
						</div>
                    </div>
                    
                 
                </div>

     
               
                
                <!-- offset area end -->
    <!-- jquery latest version -->
    <script src="assets/js/vendor/jquery-2.2.4.min.js"></script>
    <!-- bootstrap 4 js -->
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/metisMenu.min.js"></script>
    <script src="assets/js/jquery.slimscroll.min.js"></script>
    <script src="assets/js/jquery.slicknav.min.js"></script>

    <!-- start chart js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <!-- start highcharts js -->
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <!-- start amcharts -->
    <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
    <script src="https://www.amcharts.com/lib/3/ammap.js"></script>
    <script src="https://www.amcharts.com/lib/3/maps/js/worldLow.js"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
    <script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
    <!-- all line chart activation -->
    <script src="assets/js/line-chart.js"></script>
    <!-- all pie chart -->
    <script src="assets/js/pie-chart.js"></script>
    <!-- all bar chart -->
    <script src="assets/js/bar-chart.js"></script>
    <!-- all map chart -->
    <script src="assets/js/maps.js"></script>
    <!-- others plugins -->
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/scripts.js"></script>
     
         <script>
     
         $(document).ready(function () {
       	 
        	 loadcount_vehcle();
        	/*  all_person_count();
        	 all_customer_count(); */
         });
         
      function loadcount_vehcle(){
         
         $.ajax({
                contentType: "application/json",
                type: "GET",
                url: "http://localhost:9090/voteapp/total_count",
                success: function (data) {
                    //alert(data);
                  var obj = JSON.parse(data);
                  
                    var citizen_count  = obj.citizen_count;
                    var poli_count  = obj.poli_count;
                    var active_login  = obj.active_login;
                    var deactive_login  = obj.deactive_login;
                    var web_admin_login  = obj.web_admin_login;
                    var mobile_login  = obj.mobile_login;
                    var vote_s  = obj.vote_s;
                     //alert(count_vehicle);
                    //  alert(citizen_count);
                    $("#count_vehicle").append("<h4>"+citizen_count+"</h4>");
                    $("#poli_count").append("<h4>"+poli_count+"</h4>");
                    $("#active_login").append("<h4>"+active_login+"</h4>");
                    $("#deactive_login").append("<h4>"+deactive_login+"</h4>");
                    $("#web_admin_login").append("<h4>"+web_admin_login+"</h4>");
                    $("#mobile_login").append("<h4>"+mobile_login+"</h4>");
                    var green="#blink_yellow";//b1
                    var red="#blink_red";//b2
                    if(vote_s == 1){
							//active  
							//alert(vote_s);
							
							 	$(red).hide();
		                        $(green).show();
		                       $("#code").append("Vote has been Activated");
		                        
                    }else{
                    	//deactive
                    	
                    	//alert(vote_s);
                    	
                    	 $(green).hide();
                         $(red).show();
                         $("#code").append("Vote has been Deactivated");
                    }
                    
                    timer();
                    
                }
            });
            
        }
      
      function blink(selector) {
          $(selector).fadeOut('slow', function () {
             $(this).fadeIn('slow', function () {
                 blink(this);
              });
         });
     }
      
      function timer(){
    	    var counter = 15;
    	    var interval = setInterval(function() {
    	    counter--;
    	      if (counter === 0) {
    	        loadheartbeat();
    	     
    	        clearInterval(interval);
    	    
    	    }else{
    	            
    	    }
    	  }, 1000);
    	}
        
            </script>