angular.module("app")
    .service("stringService", function () {
        var getCapitalized = function (string) {
            return string[0].toUpperCase() + string.slice(1);
        };
        
        this.getAsTitle = function (camelCase) {
            return camelCase.split(/(?=[A-Z])/).map(function (string) {
                return getCapitalized(string);
            }).join(" ");
        };
        this.getAsCamelCase = function (title) {
            var camelCase = "",
                tokens = title.split(" ");
            
            for (var i = 0, len = tokens.length; i < len; i++) {
                if (i === 0) {
                    camelCase += tokens[i].toLowerCase();
                    
                } else {
                    camelCase += getCapitalized(tokens[i]);
                }
            }
            
            return camelCase;
        };
    });
