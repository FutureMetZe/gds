<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Gallery</title>
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
						<li><a href="index.do"><span data-hover="Home">Home</span></a></li>
						<li class="active"><a href="about.do"><span data-hover="About">About</span></a><span class="line1">|</span></li>
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
    <div class="jarallax agile-about-bg"></div>
     <!-- /Slider  -->
<!--//banner-->
<!-- gallery -->
<div class="jarallax w3ls-gallery agile-section" id="gallery">
	<h3 class="agileits-title">gallery</h3>
	<ul class="w3l-grid">
		<li class="col-xs-3"><a href="images/11.jpg" data-imagelightbox="g" data-ilb2-caption="Duis lobortis in ex sed cursus."><img src="images/11.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/14.jpg" data-imagelightbox="g" data-ilb2-caption="Sed accumsan auctor lacus ac mattis."><img src="images/14.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/15.jpg" data-imagelightbox="g" data-ilb2-caption="Duis lobortis in ex sed cursus."><img src="images/15.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/9.jpg" data-imagelightbox="g" data-ilb2-caption="Sed accumsan auctor lacus ac mattis."><img src="images/9.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/12.jpg" data-imagelightbox="g" data-ilb2-caption="Duis lobortis in ex sed cursus."><img src="images/12.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/13.jpg" data-imagelightbox="g" data-ilb2-caption="Sed accumsan auctor lacus ac mattis."><img src="images/13.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/5.jpg" data-imagelightbox="g" data-ilb2-caption="Duis lobortis in ex sed cursus."><img src="images/5.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/10.jpg" data-imagelightbox="g" data-ilb2-caption="Sed accumsan auctor lacus ac mattis."><img src="images/10.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/11.jpg" data-imagelightbox="g" data-ilb2-caption="Duis lobortis in ex sed cursus."><img src="images/11.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/14.jpg" data-imagelightbox="g" data-ilb2-caption="Sed accumsan auctor lacus ac mattis."><img src="images/14.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/15.jpg" data-imagelightbox="g" data-ilb2-caption="Duis lobortis in ex sed cursus."><img src="images/15.jpg" class="img-responsive" alt="gallery"></a></li>
		<li class="col-xs-3"><a href="images/9.jpg" data-imagelightbox="g" data-ilb2-caption="Sed accumsan auctor lacus ac mattis."><img src="images/9.jpg" class="img-responsive" alt="gallery"></a></li>
	</ul>
	<div class="clearfix"></div>
</div>
<!-- //gallery -->
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