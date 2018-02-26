var myApp = angular.module('myApp', ['ui.router','pascalprecht.translate'])
.config(function ($translateProvider) {
    $translateProvider.translations('en', {
      TITLE: 'Formations List',
      FOO: 'This is a paragraph.',
      BUTTON_LANG_EN: 'english',
      BUTTON_LANG_FR: 'french'
    });
    $translateProvider.translations('fr', {
      TITLE: 'Liste formations',
      FOO: 'fdfd ',
      BUTTON_LANG_EN: 'englisch',
      BUTTON_LANG_FR: 'french'
    });
    $translateProvider.preferredLanguage('en');
  })
    .config(function ($stateProvider, $urlRouterProvider) {
        $stateProvider.state('formation', {
            url: '/formations',
            views: {
                "index": {
                    templateUrl: "views/formation.html",
                    controller: "formationCtrl"
                }
            }
        });

        $stateProvider.state('afficheFormation', {
            url: '/formations/:id',
            views: {
                "index": {
                    templateUrl: "views/afficheFormation.html",
                    controller: "afficheFormationCtrl"
                }
            }
        });
        $stateProvider.state('ajouterFormation', {
            url: '/formations/new',
            views: {
                "index": {
                    templateUrl: "views/ajouterFormation.html",
                    controller: "ajouterFormationCtrl"
                }
            }
        });
        $stateProvider.state('updateFormation', {
            url: '/formations/update/:id',
            views: {
                "index": {
                    templateUrl: "views/updateFormation.html",
                    controller: "updateFormationCtrl"
                }
            }
        });
        $stateProvider.state('dashboard', {
            url: '/',
            views: {
                "index": {
                    templateUrl: "views/dashboard.html",
                    controller: "dashboardCtrl"
                }
            }
        });
        $stateProvider.state('enseignant', {
            url: '/enseignants',
            views: {
                "index": {
                    templateUrl: "views/views_enseignant/enseignant.html",
                    controller: "enseignantCtrl"
                }
            }
        });
        $stateProvider.state('afficheEnseignant', {
            url: '/enseignants/:id',
            views: {
                "index": {
                    templateUrl: "views/views_enseignant/afficheEnseignant.html",
                    controller: "afficheEnseignantCtrl"
                }
            }
        });
        $stateProvider.state('ajouterEnseignant', {
            url: '/enseignants/new',
            views: {
                "index": {
                    templateUrl: "views/views_enseignant/ajouterEnseignant.html",
                    controller: "ajouterEnseignantCtrl"
                }
            }
        });
        $stateProvider.state('updateEnseignant', {
            url: '/enseignants/update/:id',
            views: {
                "index": {
                    templateUrl: "views/views_enseignant/updateEnseignant.html",
                    controller: "updateEnseignantCtrl"
                }
            }
        });
        $urlRouterProvider.otherwise('/');
    });
myApp.controller("dashboardCtrl", function ($scope, $http, $stateParams) {
    $scope.enseignants = [];
    $http.get("http://localhost:8090/enseignants/")
        .then((res) => {
            console.log(res);
            $scope.enseignants = res.data;
        })
    $scope.formations = [];
    $http.get("http://localhost:8090/formations/")
        .then((res) => {
            console.log(res);
            $scope.formations = res.data;
        })
    $scope.candidats = [];
    $http.get("http://localhost:8090/candidats/")
        .then((res) => {
            console.log(res);
            $scope.candidats = res.data;
        })
    $scope.promotions = [];
    $http.get("http://localhost:8090/promotions/")
        .then((res) => {
            console.log(res);
            $scope.promotions = res.data;
        })
});