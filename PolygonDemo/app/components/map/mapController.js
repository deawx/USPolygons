angular.module("app")
    .controller("mapController", ["mapConstants", "stringService", function (mapConstants, stringService) {
        var self = this,
            regionConstants = mapConstants.regions,
            regionName = null,
            divisionName = null,
            stateName = null,
            getKeyArray = function (objectLiteral) {
                var keyArray = [];
                for (var key in objectLiteral) {
                    if (!objectLiteral.hasOwnProperty(key)) {
                        continue;
                    }
                    keyArray.push(key);
                }
                return keyArray;
            };
    
        this.regionNames = getKeyArray(regionConstants);
        this.divisionNames = [];
        this.stateNames = [];
    
        this.onSelectRegionName = function (selectedRegionName) {
            self.divisionNames = getKeyArray(regionConstants[selectedRegionName].divisions);
            self.stateNames = [];
            regionName = selectedRegionName;
            divisionName = null;
            stateName = null;
        };
        this.onSelectDivisionName = function (selectedDivisionName) {
            self.stateNames = regionConstants[regionName]
                .divisions[selectedDivisionName]
                .states;
            divisionName = selectedDivisionName;
            stateName = null;
        };
        this.onSelectStateName = function (selectedStateName) {
            stateName = selectedStateName;
        };
        
        this.regionWasSelected = function () {
            return regionName !== null;
        };
        this.divisionWasSelected = function () {
            return divisionName !== null;
        };
    }]);
