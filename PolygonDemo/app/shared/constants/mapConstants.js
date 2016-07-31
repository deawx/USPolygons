angular.module("app")
    .constant("mapConstants", {
        "regions": {
            "Midwest": {
                "divisions": {
                    "East North Central": {
                        "states": [
                            "Illinois",
                            "Indiana",
                            "Michigan",
                            "Ohio",
                            "Wisconsin"
                        ]
                    },
                    "West North Central": {
                        "states": [
                            "Iowa",
                            "Kansas",
                            "Minnesota",
                            "Nebraska",
                            "North Dakota",
                            "South Dakota"
                        ]
                    }
                }
            },
            "Northeast": {
                "divisions": {
                    "Middle Atlantic": {
                        "states": [
                            "New Jersey",
                            "New York",
                            "Pennsylvania"
                        ]
                    },
                    "New England": {
                        "states": [
                            "Connecticut",
                            "Maine",
                            "Massachusetts",
                            "New Hampshire",
                            "Rhode Island",
                            "Vermont"
                        ]
                    }
                }
            },
            "South": {
                "divisions": {
                    "East South Central": {
                        "states": [
                            "Alabama",
                            "Kentucky",
                            "Mississippi",
                            "Tennessee"
                        ]
                    },
                    "South Atlantic": {
                        "states": [
                            "Delaware",
                            "Florida",
                            "Georgia",
                            "Maryland",
                            "North Carolina",
                            "South Carolina",
                            "Virginia",
                            "West Virginia"
                        ]
                    },
                    "West South Central": {
                        "states": [
                            "Arkansas",
                            "Louisiana",
                            "Oklahoma",
                            "Texas"
                        ]
                    }
                }
            },
            "West": {
                "divisions": {
                    "Mountain": {
                        "states": [
                            "Arizona",
                            "Colorado",
                            "Idaho",
                            "Montana",
                            "Nevada",
                            "New Mexico",
                            "Utah",
                            "Wyoming"
                        ]
                    },
                    "Pacific": {
                        "states": [
                            "Alaska",
                            "California",
                            "Hawaii",
                            "Oregon",
                            "Washington"
                        ]
                    }
                }
            }
        }
    });