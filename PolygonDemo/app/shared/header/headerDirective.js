angular.module("app")
    .directive("headerDirective", function () {
        return {
            restrict: "E",
            transclude: true,
            templateUrl: "app/shared/header/headerView.html",
            controller: "headerController"
        };
    });
