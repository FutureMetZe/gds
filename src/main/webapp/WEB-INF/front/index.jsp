<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<!-- css files -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/set2.css" />
<link href="css/imagelightbox.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- /css files -->
<!-- fonts -->
<link href="http://fonts.googleapis.com/css?family=Rajdhani:300,400,500,600,700" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<!-- fonts -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>

<!-- navigation -->
<div class="navbar-wrapper">
    <div class="container-fluid">
		<nav class="navbar navbar-inverse navbar-static-top cl-effect-5">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.do"><h1>Scholar </h1></a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="index.do"><span data-hover="家">家</span></a></li>
						<li><a href="about.do"><span data-hover="About">媒体展示</span></a><span class="line1">|</span></li>
						<li><a href="gallery.do"><span data-hover="Gallery">Gallery</span></a><span class="line1">|</span></li>
						<li><a href="service.do"><span data-hover="Services">Services</span></a><span class="line1">|</span></li>
						<li><a href="icons.do" data-toggle="dropdown"><span data-hover="ShortCodes">Short Codes</span><span class="caret"></span></a><span class="line1">|</span>
							<ul class="dropdown-menu">
								<li><a href="icons.do"><span data-hover="Icons">Icons</span></a></li>
								<li><a href="typography.do"><span data-hover="Typograpghy">Typograpghy</span></a></li>
							</ul>
						</li>	
						<li><a href="contact.do"><span data-hover="Contact">Contact</span></a><span class="line1">|</span></li>
					</ul>
				</div>
			</div>
        </nav>
	</div>
</div>	
<!-- //navigation -->
<!--//banner section starts here-->
    <!-- Slider  -->
    <div class="jarallax callbacks_container w3-layouts">
      <ul class="rslides callbacks callbacks1 agileits" id="slider4">
        <li id="callbacks1_s1" class="" style="float: none; position: absolute; opacity: 0; z-index: 1; display: list-item; transition: opacity 500ms ease-in-out;">
          <img src="images/b1.jpg" alt="home" />
          <div class="caption text-center"><h3>Lorem ipsum dolor sit amet.</h3><p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet.</p></div>
        </li>
		 <li id="callbacks1_s2" class="" style="float: none; position: absolute; opacity: 0; z-index: 1; display: list-item; transition: opacity 500ms ease-in-out;">
          <img src="images/b2.jpg" alt="home" />
          <div class="caption text-center"><h3>Lorem ipsum dolor sit amet.</h3><p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet.</p></div>
        </li>
        <li id="callbacks1_s3" class="callbacks1_on" style="float: left; position: relative; opacity: 1; z-index: 2; display: list-item; transition: opacity 500ms ease-in-out;">
          <img src="images/b3.jpg" alt="home" />
          <div class="caption text-center"><h3>Lorem ipsum dolor sit amet.</h3> <p> Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet.</p></div>
        </li>
		<li id="callbacks1_s6" class="callbacks1_on" style="float: left; position: relative; opacity: 1; z-index: 2; display: list-item; transition: opacity 500ms ease-in-out;">
          <img src="images/b7.jpg" alt="home" />
          <div class="caption text-center"><h3>Lorem ipsum dolor sit amet.</h3> <p> Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet.</p></div>
        </li>
      </ul>
	  		<a href="#" class="callbacks_nav callbacks1_nav prev">Previous</a><a href="#" class="callbacks_nav callbacks1_nav next">Next</a>
    </div>
     <!-- /Slider  -->
<!--//banner-->
<!-- about -->
<div class="jarallax w3ls-about agile-section" id="about">
	<div class="container">
		<div class="w3-agileits-about-grids">
			<div class="col-md-6 agile-about-left">
				<h2 class="agileits-title">welcome to Scholar </h2>
				<h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget faucibus est.</h5>
				<p>Suspendisse auctor urna blandit ultricies maximus. Sed accumsan auctor lacus ac mattis. Mauris at nibh purus. Nullam vulputate, urna id facilisis eleifend, nisl turpis suscipit augue, eget tincidunt velit nunc ut lectus. <span>Phasellus viverra nec augue at iaculis. Nullam scelerisque tincidunt sapien vitae sodales. Sed tristique ut nulla a ultricies. Aliquam sit amet sodales elit, et pellentesque lorem. Praesent quis nibh id arcu porta lobortis.</span> Morbi rutrum ut risus sed hendrerit. Integer laoreet odio nec nisi varius, at scelerisque nisi rhoncus.</p>
			</div>
			<div class="col-md-6 agile-about-right"></div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- //about -->
<!-- services -->
<div class="jarallax w3ls-services agile-section" id="services">
	<div class="container">
		<h3 class="agileits-title">services</h3>
		<div class="w3-agileits-service-grids">
			<div class="col-md-5 agile-service-left">
				<h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</h5>
			</div>	
			<div class="col-md-7 agile-service-right">
				<p>Suspendisse auctor urna blandit ultricies maximus. Sed accumsan auctor lacus ac mattis. Mauris at nibh purus. Nullam vulputate, urna id facilisis eleifend, nisl turpis suscipit augue, eget tincidunt velit nunc ut lectus.Morbi rutrum ut risus sed hendrerit. Integer laoreet odio nec nisi varius, at scelerisque nisi rhoncus.</p>
			</div>
			<div class="clearfix"> </div>
		</div>
		<div class="agile_service_bottom_grids">
			<div class="col-md-4 col-sm-4 w3_service_bottom_grid1 ">
				<div class="agileits_service_left">
						<i class="fa fa-book" aria-hidden="true"></i>
				</div>
				<div class="agileits_service_right">
					<h4>Etiam ac risus</h4>
					<p>Duis lobortis in ex sed cursus. Etiam ac risus at ex blandit placerat id ac augue.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-4 col-sm-4 w3_service_bottom_grid1 w3l-s2">
				<div class="agileits_service_left">
						<i class="fa fa-trophy" aria-hidden="true"></i>
				</div>
				<div class="agileits_service_right">
					<h4>Etiam ac risus</h4>
					<p>Duis lobortis in ex sed cursus. Etiam ac risus at ex blandit placerat id ac augue.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-4 col-sm-4 w3_service_bottom_grid1">
				<div class="agileits_service_left">
						<i class="fa fa-university" aria-hidden="true"></i>
				</div>
				<div class="agileits_service_right">
					<h4>Etiam ac risusy</h4>
					<p>Duis lobortis in ex sed cursus. Etiam ac risus at ex blandit placerat id ac augue.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>	
<!-- //services -->
<!-- team -->
<div class="jarallax agileits-team agile-section" id="team">
	<h3 class="agileits-title">our staff</h3>
	<div class="grid">
		<figure class="col-md-3 effect-kira">
			<img src="images/t1.jpg" alt="t1" class="img-responsive"/>
			<figcaption>
				<h4>Williams</h4>
				<h5>learning support</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<figure class="col-md-3 effect-kira">
			<img src="images/t2.jpg" alt="t2" class="img-responsive"/>
			<figcaption>
				<h4>Dark <span>Kira</span></h4>
				<h5>kindergarten</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<figure class="col-md-3 effect-kira">
			<img src="images/t3.jpg" alt="t3" class="img-responsive"/>
			<figcaption>
				<h4>Irving</h4>
				<h5>art</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<figure class="col-md-3 effect-kira">
			<img src="images/t4.jpg" alt="t4" class="img-responsive"/>
			<figcaption>
				<h4>Kenny</h4>
				<h5>Dept. of maths</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<figure class="col-md-3 effect-kira">
			<img src="images/t5.jpg" alt="t5" class="img-responsive"/>
			<figcaption>
				<h4>Lawrence</h4>
				<h5>Academic support</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<figure class="col-md-3 effect-kira">
			<img src="images/t6.jpg" alt="t6" class="img-responsive"/>
			<figcaption>
				<h4>Jackson</h4>
				<h5>Dept. of English</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<figure class="col-md-3 effect-kira">
			<img src="images/t7.jpg" alt="t7" class="img-responsive"/>
			<figcaption>
				<h4>Stephen</h4>
				<h5>Dept. of Science</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<figure class="col-md-3 effect-kira">
			<img src="images/t8.jpg" alt="t8" class="img-responsive"/>
			<figcaption>
				<h4>Goode</h4>
				<h5>sports coach</h5>
				<p>
					<a href="#" class="fa fa-facebook icon-border facebook"></a>
					<a href="#" class="fa fa-twitter  icon-border twitter"></a>
					<a href="#" class="fa fa-google-plus  icon-border googleplus"></a>
					<a href="#" class="fa fa-linkedin icon-border linkedin"></a>
				</p>
			</figcaption>			
		</figure>
		<div class="clearfix"></div>
	</div>				
</div>	
<!-- //team-->
<!-- Stats --> 
<div class="jarallax w3ls-stats agile-section" id="stats">
	<h3 class="agileits-title">look what we accomplished..</h3>
	<div class="col-md-4 projects-right1"></div>
	<div class="col-md-8 stats news-w3layouts">  
		<div class="stats-info agileits-w3layouts">
			<div class="col-sm-4 col-xs-4 stats-grid">
				<div class="col-sm-3 stats-img stat1">
					<i class="fa fa-check-square-o" aria-hidden="true"></i>
				</div>
				<div class="col-sm-9 stats-img stat2">
						<p>branches</p>
				</div>
				<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='324' data-delay='.5' data-increment="1">324</div>
			</div>
			<div class="col-sm-4 col-xs-4 stats-grid">
				<div class="col-sm-3 stats-img stat1">
					<i class="fa fa-heart-o" aria-hidden="true"></i>
				</div>
				<div class="col-sm-9 stats-img stat2">
					<p>Happy parents</p> 
				</div>				
				
				<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='200' data-delay='.5' data-increment="1">200</div>
			</div>
			<div class="col-sm-4 col-xs-4 stats-grid stat1">
				<div class="col-sm-3 stats-img stat1">
					<i class="fa fa-trophy" aria-hidden="true"></i>
				</div>
				<div class="col-sm-9 stats-img stat2">
					<p>Awards</p> 
				</div>
				<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='156' data-delay='.5' data-increment="1">156</div>
			</div>
			<div class="clearfix"></div>
		</div> 
	</div>  
	<div class="clearfix"></div>
</div>	
<script type="text/javascript" src="js/numscroller-1.0.js"></script>
<!-- //Stats -->  
<!--testimonials-->
<div class="jarallax agileits-testimonials agile-section" id="testimonials">
	<div class="container">
		<!--screen-gallery-->
			<div class="col-md-5 col-sm-12 wthree-testimonials-left">
				<h3 class="agileits-title">testimonials</h3>
				<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque
				corrupt.</p>
			</div>
			<div class="col-md-7 col-sm-12 wthree-testimonials-right">
				<div class="sreen-gallery-cursual">
							 <!-- required-js-files-->
							<link href="css/owl.carousel.css" rel="stylesheet">
							    <script src="js/owl.carousel.js"></script>
							        <script>
							    $(document).ready(function() {
							      $("#owl-demo").owlCarousel({
							        items :1,
							        lazyLoad : true,
							        autoPlay : false,
							        navigation :true,
							        navigationText :  false,
							        pagination : true,
							      });
							    });
							    </script>
								 <!--//required-js-files-->
						       <div id="owl-demo" class="owl-carousel">
							      <div class="item-owl">
					                	<div class="customer-say">
											  <div class="col-md-6 col-sm-6 col-xs-6 customer-grid">
												<div class="de_testi">
													<div class="de_testi_by">
														<h4>"lorem ipsum"</h4>
														<h5 class="w3l">sed do eiusmod consectetu</h5>
														<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
														<div class="quotes">
															<img src="images/p1.jpg" alt="">
															<a href="#">Allen</a><p>, Parent</p>
														</div>		
													</div>
													<div class="clearfix"></div>     
												</div>
											   </div>
											<div class="col-md-6 col-sm-6 col-xs-6 customer-grid">
												<div class="de_testi">
													<div class="de_testi_by">
														<h4>"lorem ipsum"</h4>
														<h5 class="w3l">sed do eiusmod consectetu</h5>
														<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
														<div class="quotes">
															<img src="images/p2.jpg" alt="">
															<a href="#">Michael </a><p>, Parent</p>
														</div>		
													</div>
													<div class="clearfix"></div>     
												</div>
											</div>
											
											<div class="clearfix"></div>
										</div>	
					              </div>
					                <div class="item-owl">
					                	<div class="customer-say">
											  <div class="col-md-6 col-sm-6 col-xs-6 customer-grid">
												<div class="de_testi">
													<div class="de_testi_by">
														<h4>"lorem ipsum"</h4>
														<h5 class="w3l">sed do eiusmod consectetu</h5>
														<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
														<div class="quotes">
															<img src="images/p3.jpg" alt="">
															<a href="#">Merrick</a><p>, Parent</p>
														</div>	
													</div>
													<div class="clearfix"></div>     
												</div>
											   </div>
											<div class="col-md-6 col-sm-6 col-xs-6 customer-grid">
												<div class="de_testi">
													<div class="de_testi_by">
														<h4>"lorem ipsum"</h4>
														<h5 class="w3l">sed do eiusmod consectetu</h5>
														<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
														<div class="quotes">
															<img src="images/p1.jpg" alt="">
															<a href="#">Allen</a><p>, Parent</p>
														</div>	
													</div>
													<div class="clearfix"></div>     
												</div>
											</div>
											
											<div class="clearfix"></div>
										</div>	
					              </div>
								  <div class="item-owl">
					                	<div class="customer-say">
											  <div class="col-md-6 col-sm-6 col-xs-6 customer-grid">
												<div class="de_testi">
													<div class="de_testi_by">
														<h4>"lorem ipsum"</h4>
														<h5 class="w3l">sed do eiusmod consectetu</h5>
														<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
														<div class="quotes">
															<img src="images/p2.jpg" alt="">
															<a href="#">Michael </a><p>, Parent</p>
														</div>
													</div>
													<div class="clearfix"></div>     
												</div>
											   </div>
											<div class="col-md-6 col-sm-6 col-xs-6 customer-grid">
												<div class="de_testi">
													<div class="de_testi_by">
														<h4>"lorem ipsum"</h4>
														<h5 class="w3l">sed do eiusmod consectetu</h5>
														<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
														<div class="quotes">
															<img src="images/p3.jpg" alt="">
															<a href="#">Merrick </a><p>, Parent</p>
														</div>		
													</div>
													<div class="clearfix"></div>     
												</div>
											</div>
											
											<div class="clearfix"></div>
										</div>	
					              </div>
				              </div>
						</div>
						<!--//screen-gallery-->
			</div>
			<div class="clearfix"></div>	
	</div>	
</div>	
<!--//testimonials-->
<!-- contact -->
<div class="jarallax agileits-contact agile-section" id="contact">
	<div class="container">
		<h3 class="agileits-title">contact</h3>
		<div class="w3agile-contact">
			<div class="col-md-5 col-sm-5 col-xs-6 w3_agileits-contact-left">
				<div class="wthree-address">
					<div class="col-md-2 col-sm-1 col-xs-1 agile-icon">
						<span class="fa fa-map-signs" aria-hidden="true"></span>
					</div>
					<div class="col-md-10 col-sm-11 col-xs-11 w3_agile-contact-text">
						<h5>address</h5>
						<p>159 Cessna Drive,Fort Wayne,Missouri.</p>
					</div>
					<div class="clearfix"></div>
				</div>	
				<div class="wthree-address">
					<div class="col-md-2 col-sm-1 col-xs-1 agile-icon">
						<span class="fa fa-phone" aria-hidden="true"></span>
					</div>	
					<div class="col-md-10 col-sm-11 col-xs-11 w3_agile-contact-text">
						<h5>phone</h5>
						<p>260-414-2286</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="wthree-address">
					<div class="col-md-2 col-sm-1 col-xs-1 agile-icon">
							<span class="fa fa-envelope" aria-hidden="true"></span>
					</div>	
					<div class="col-md-10 col-sm-11 col-xs-11  w3_agile-contact-text">
						<h5>mail us</h5>
						<a href="mailto:info@example.com">info@example.com</a>
					</div>
					<div class="clearfix"></div>
				</div>		
				<div class="clearfix"></div>
			</div>
			<div class="col-md-7 col-sm-7 col-xs-6 contact-right-w3l">
				<form action="#" method="post">
					<input type="text" class="name" name="name" placeholder="First Name" required="">
					<input type="text" class="name" name="name" placeholder="Last Name" required="">
					<input type="email" class="name" name="name" placeholder="Email" required="">
					<input type="text" class="name" name="name" placeholder="Subject" required="">
					<textarea placeholder="Your Message" required=""></textarea>
					<input type="submit" value="SEND MESSAGE">
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>	
</div>
<!-- //contact -->
<!-- footer -->
<div class="agileits_w3layouts-footer">
	<div class="container">
		<div class="agileinfo-footer">
			<div class="col-md-6 col-sm-6 social-icons">
				<ul>
					<li><a href="#" class="fa fa-facebook icon-border facebook"> </a></li>
					<li><a href="#" class="fa fa-twitter  icon-border twitter"> </a></li>
					<li><a href="#" class="fa fa-google-plus  icon-border googleplus"> </a></li>
				</ul>
			</div>
			<div class="col-md-6 col-sm-6 w3_agile-copyright text-center">
				<p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			</div>
		</div>
	</div>
</div>
<!-- //footer -->
<script src="js/imagelightbox.js"></script>
<script>
$('a[data-imagelightbox="g"]').imageLightbox({
        activity: true,
        arrows: true,
        button: true,
        caption: true,
        navigation: true,
        overlay: true,
        quitOnDocClick: false,
        selector: 'a[data-imagelightbox="f"]'
    });
</script>
<!-- Banner-plugin -->
<script src="js/responsiveslides.min.js"></script>
<script>
// You can also use "$(window).load(function() {"
$(function () {
  // Slider
  $("#slider4").responsiveSlides({
	auto:true,
	pager: false,
	nav: true,
	speed: 500,
	namespace: "callbacks",
	before: function () {
	  $('.events').append("<li>before event fired.</li>");
	},
	after: function () {
	  $('.events').append("<li>after event fired.</li>");
	}
  });

});
</script>
<!-- //Banner-plugin -->
<script src="js/jarallax.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script type="text/javascript">
	/* init Jarallax */
	$('.jarallax').jarallax({
		speed: 0.5,
		imgWidth: 1366,
		imgHeight: 768
	})
</script>
<!-- here starts scrolling icon -->
		<script type="text/javascript">
			$(document).ready(function() {
				/*
					var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
					};
				*/
										
				$().UItoTop({ easingType: 'easeOutQuart' });
									
				});
		</script>
		
		<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
		<!-- /ends-smoth-scrolling -->
	<!-- //here ends scrolling icon -->

</body>
</html>