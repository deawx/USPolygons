angular.module("app")
    .directive("footerDirective", function () {
        return {
            restrict: "E",
            transclude: false,
            templateUrl: "app/shared/footer/footerView.html",
            controller: "footerController"
        };
    });
