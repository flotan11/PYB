<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
		<!-- <script type="text/javascript"></script> -->
		<script src='jquery-2.1.3.js'></script>
		<link rel="stylesheet" type="text/css" href="css/styles.css"/>
		<link rel="stylesheet" type="text/css" href="css/connexion.css"/>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript">
      	function envoyer_connexion(){
      		var inputLog = $("#inputIdentifiant").val();
      		console.log("input log :" + inputLog);
      		var inputMdp = $("#inputPassword").val();
      		console.log("input mdp :" + inputMdp);
      		$.ajax({
					url:"data/users",
					type:"GET",
					dataType :"json",
				
					success: function(json) {
						for (var i = 0; i < json.length; i++) {
							if (json[i].login == inputLog && json[i].mdp == inputMdp) {
								console.log("succes de json");
								document.getElementById("status").innerHTML = "Connecté - "+ inputLog;
							}
						}
					}
				});
      	}

      </script>
	</head>
	<header>
		<!--<h1>Bienvenue sur Place Your Bets</h1> -->
	</header>
	<body>
		<div class="navbar-wrapper">
		      <div class="container">

		        <nav class="navbar navbar-inverse navbar-static-top">
		          <div class="container">
		            <div class="navbar-header">
		              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		                <span class="sr-only">Toggle navigation</span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		              </button>
		              <a class="navbar-brand" href="accueil.html">Place Your Bets</a>
		            </div>
		            <div id="navbar" class="navbar-collapse collapse">
		              <ul class="nav navbar-nav">
		                <li class="active"><a href="accueil.html">Accueil</a></li>
		                <li><a href="inscription.html">Inscription</a></li>
		                <li class="dropdown">
		                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Jouer<span class="caret"></span></a>
		                  <ul class="dropdown-menu">
		                    <li><a href="create_bet.html">Créer un pari</a></li>
		                    <li><a href="betlist.html">Mes paris</a></li>
		                    <li><a href="allbets.html">Tous les paris en cours</a></li>
		                  </ul>
		                </li>
		                <li><a href="betlist.html">Mes paris</a></li>
		                <li class="dropdown">
		                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mes informations<span class="caret"></span></a>
		                  <ul class="dropdown-menu">
		                    <li><a href="profil.html">Profil</a></li>
		                    <li><a href="informations.html">Statistiques</a></li>
		                    <li><a href="solde.html">Recharger solde</a></li>
		                    <li><a href="#">Deconnexion</a></li>
		                  </ul>
		                </li>
		                <li id="status">
		                	<a>Vous n'êtes pas connecté</a>
		                </li>
		              </ul>
		            </div>
		          </div>
		        </nav>

		     	 </div>
		    	</div>

		<div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Connectez-vous</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputIdentifiant" class="form-control" placeholder="Identifiant" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Mot de passe" required>
        <button id="submit-button" class="btn btn-lg btn-primary btn-block" onClick="envoyer_connexion()">Connexion</button>
      </form>
      


    </div>
    <script>
$(document).ready(function() {
  $("#submit-button").on('click',function(event) {
    event.preventDefault();
  });
});
</script>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>
