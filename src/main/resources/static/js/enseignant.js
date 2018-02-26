
myApp.controller("enseignantCtrl", function ($scope, $http) {
    $scope.enseignants = [];
    $http.get("http://localhost:8090/enseignants")
        .then((data) => {
            $scope.enseignants  = data.data;
            setTimeout(() => {
                $(document).ready(function () {
                    $('#enseignants ').DataTable();
                });
            }, 0);
        });
        $scope.delete = (id) => {
            $http.delete("http://localhost:8090/enseignants/" + id)
                .then(() => {
                    $http.get("http://localhost:8090/enseignants")
                        .then((data) => {
                            $scope.enseignants = data.data;
                        });
                });
        };
});
myApp.controller("afficheEnseignantCtrl", function ($scope, $http, $stateParams) {
    console.log($stateParams);
    $scope.enseignant = {};
    $http.get("http://localhost:8090/enseignants/" + $stateParams.id)
        .then((res) => {
            console.log(res);
            $scope.enseignant = res.data;
        })
});
myApp.controller("ajouterEnseignantCtrl", function ($scope, $http,$state) {
    $scope.enseignant = {};
    $scope.ajouter = () => {
        console.log("54548184");
        $http.post("http://localhost:8090/enseignants/", $scope.enseignant)
            .success(function (enseignant) {
                $state.go("enseignant");
                

            });
    }
});
myApp.controller("updateEnseignantCtrl", function ($scope, $http, $state, $stateParams) {
    $scope.enseignants = {};
    $http.get("http://localhost:8090/enseignants/"+$stateParams.id)
    .then((res) => {
        $scope.enseignant = res.data;
        
    });
    $scope.update = () => {
        $http.put("http://localhost:8090/enseignants", $scope.enseignant)
        .then((res) => {
            $state.go("enseignant");
        })
    };
    $scope.annuler = () => {
        $state.go("enseignant");
        
};
});
myApp.controller("homeCtrl", function ($scope, $http) {

});
