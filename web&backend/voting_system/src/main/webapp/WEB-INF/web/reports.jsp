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
    <!-- amcharts css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <!-- Start datatable css -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.jqueryui.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="assets/css/typography.css">
    <link rel="stylesheet" href="assets/css/default-css.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/responsive.css">
    
     <link href="assets/css/lib/data-table/buttons.bootstrap.min.css" rel="stylesheet" />
    
    <!-- modernizr css -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>



                <div class="row">
                  <div class="col-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">Vote report</h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                        <table class="table table-hover progress-table text-center">
                                            <thead class="text-uppercase">
                                                <tr>
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Vote Count</th>
                                                    <th scope="col">Election Number</th>
                                                    <th scope="col">Team Name</th>
                                                    <th scope="col">Person Name</th>
                                                    <th scope="col">District Name</th>
                                                    
                                                    
                                                </tr>
                                            </thead>
                                            <tbody id="tbody_shop">
                                         
                                               
                                               
                                            </tbody>
                                        </table>
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

    <!-- Start datatable js -->
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
    <script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap.min.js"></script>
    <!-- others plugins -->
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/scripts.js"></script>
    
    
 
    <!-- nano scroller -->
    <script src="assets/js/lib/menubar/sidebar.js"></script>
    <script src="assets/js/lib/preloader/pace.min.js"></script>
    <!-- sidebar -->
    
    <!-- bootstrap -->

    <script src="assets/js/lib/bootstrap.min.js"></script><script src="assets/js/scripts.js"></script>
    <!-- scripit init-->
    <script src="assets/js/lib/data-table/datatables.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.dataTables.min.js"></script>
    <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.flash.min.js"></script>
    <script src="assets/js/lib/data-table/jszip.min.js"></script>
    <script src="assets/js/lib/data-table/pdfmake.min.js"></script>
    <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
    <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
    <script src="assets/js/lib/data-table/datatables-init.js"></script>
    
    
    
     <script type='text/javascript'>
       
       $(document).ready(function () {

    	   load_vote_result();
    	   
    	   
                              });
       
  
     
  function load_vote_result(){
	  
	 
	  
	    
	  $("#tbody_shop").empty();
	  
		$.ajax({
	           contentType: "application/json",
	           type: "GET",
	           url: "get_polition_list_vote",
	            success: function (data) {
		         // alert(data);
	           var json = JSON.parse(data);
	           var trHTML = '';
	           var initial_name="",status_name="";
	           
	                    for(var i=0;i<json.length;i++){
	                    
	                      var id=json[i]['id'];
	                      var poli_status=json[i]['poli_status'];
	                      var vote_count=json[i]['vote_count'];
	                      var person_fname=json[i]['person_fname'];
	                      var person_lname=json[i]['person_lname'];
	                      var person_id=json[i]['person_id'];
	                      var team_id=json[i]['team_id'];
	                      var team_name=json[i]['team_name'];
	                      var election_number=json[i]['election_number'];
	                      var name_person= person_fname+" "+person_lname;
	                      var district_name=json[i]['district_name'];
	                      
							       	        
	                 	                               
trHTML +='<tr><th scope="row">'+ id +'</th><td><span class="status-p bg-danger">'+vote_count+'</span></td><td scope="row" ><span class="status-p bg-primary">'+election_number+'</span></th><td>'+team_name+'</td><td>'+name_person+'</td><td><span class="status-p bg-danger">'+district_name+'</span></td></tr>';
	                
	                     
	                     
	                 } 
	                    
	                    $('#tbody_shop').append(trHTML);
	                             
	              }
	              
	      });
	  }

    
</script>                     
     