angular.module("app", [
        "app",
        "ui.router"
    ])
    .config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state("map", {
                url: "/",
                templateUrl: "app/components/map/mapView.html"
            });
        
        $urlRouterProvider.otherwise("/");
    }]);
