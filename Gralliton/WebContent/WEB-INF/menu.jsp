<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- 
<nav class="navbar navbar-expand-lg navbar-white bg-manavbar" style= "background-color: #343434" >
	<a class="navbar-brand" href="#" style= "color : #ffffff;"> 
	<img src="images/cat.svg" class="d-inline-block align-top" width="30" height="30" alt="">
		Gralliton
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<form class="form-inline mr-auto">
      <input class="form-control" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-mdb-color btn-rounded btn-sm my-0 ml-sm-2" type="submit" style= "background-color: #C7C7C7">Go</button>
    </form>
    <a class="navbar-brand" href="#" style= "color : #C7C7C7;">Sign in</a>
	<a class="navbar-brand" href="#" style= "color : #C7C7C7;">Register</a>
	
</nav>
 -->
<div class="wrapper">
    <!-- Sidebar -->
    <nav id="sidebar">

        <div id="dismiss">
            <i class="fas fa-arrow-left"></i>
        </div>

        <div class="sidebar-header">
            <h3>Bootstrap Sidebar</h3>
        </div>

      
    </nav>

    <!-- Page Content -->
    <div id="content">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>Toggle Sidebar</span>
                </button>
            </div>
        </nav>
    </div>
    <!-- Dark Overlay element -->
    <div class="overlay"></div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#sidebar").mCustomScrollbar({
            theme: "minimal"
        });

        $('#dismiss, .overlay').on('click', function () {
            // hide sidebar
            $('#sidebar').removeClass('active');
            // hide overlay
            $('.overlay').removeClass('active');
        });

        $('#sidebarCollapse').on('click', function () {
            // open sidebar
            $('#sidebar').addClass('active');
            // fade in the overlay
            $('.overlay').addClass('active');
            $('.collapse.in').toggleClass('in');
            $('a[aria-expanded=true]').attr('aria-expanded', 'false');
        });
    });
</script>