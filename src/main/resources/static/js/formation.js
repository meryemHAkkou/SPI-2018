
myApp.controller("formationCtrl", function ($scope, $http, $translate) {
    $scope.formations = [];
    $scope.changeLanguage = function (key) {
        $translate.use(key);
      };
    $http.get("http://localhost:8090/formations")
        .then((data) => {
            $scope.formations = data.data;
            setTimeout(() => {
                $(document).ready(function () {
                    $('#formations').DataTable();
                });
            }, 0);

        });
    $scope.delete = (id) => {
        $http.delete("http://localhost:8090/formations/" + id)
            .then(() => {
                $http.get("http://localhost:8090/formations")
                    .then((data) => {
                        $scope.formations = data.data;
                    });
            });
    };
});
myApp.controller("afficheFormationCtrl", function ($scope, $http, $stateParams) {
    console.log($stateParams);
    $scope.formation = {};
    $http.get("http://localhost:8090/formations/" + $stateParams.id)
        .then((res) => {
            console.log(res);
            $scope.formation = res.data;
        })
});
myApp.controller("ajouterFormationCtrl", function ($scope, $http,$state) {
    console.log("bonjour meryem");
    $scope.formation = {};
    $scope.ajouter = () => {
        console.log("sfsdfsd");
        $http.post("http://localhost:8090/formations/", $scope.formation)
            .success(function (formation) {
                $state.go("formation");
                
            });
    }
});
myApp.controller("updateFormationCtrl", function ($scope, $http, $state, $stateParams) {
    $scope.formation = {};
    $http.get("http://localhost:8090/formations/"+$stateParams.id)
    .then((res) => {
        $scope.formation = res.data;
        $scope.formation.debutAccreditation = new Date($scope.formation.debutAccreditation);
        $scope.formation.finAccreditation = new Date($scope.formation.finAccreditation);
    });
    $scope.update = () => {
        $http.put("http://localhost:8090/formations", $scope.formation)
        .success(function (formation) {
            $state.go("formation");
            
        });
    };
    $scope.annuler = () => {
            $state.go("formation");
            
    };
});
myApp.controller("homeCtrl", function ($scope, $http) {

});
