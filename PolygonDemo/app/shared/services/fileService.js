angular.module("app")
    .service("fileService", ["$resource", function ($resource) {
        this.requestFileResource = function (filepath) {
            return $resource(filepath);
        };
    }]);
