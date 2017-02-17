'use strict';

angular.module('creamApp')
    .factory('Personne', function ($resource, DateUtils) {
        return $resource('api/personnes/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.dateNaissance = DateUtils.convertLocaleDateFromServer(data.dateNaissance);
                    data.dateObtentionPermis = DateUtils.convertLocaleDateFromServer(data.dateObtentionPermis);
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    data.dateNaissance = DateUtils.convertLocaleDateToServer(data.dateNaissance);
                    data.dateObtentionPermis = DateUtils.convertLocaleDateToServer(data.dateObtentionPermis);
                    return angular.toJson(data);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    data.dateNaissance = DateUtils.convertLocaleDateToServer(data.dateNaissance);
                    data.dateObtentionPermis = DateUtils.convertLocaleDateToServer(data.dateObtentionPermis);
                    return angular.toJson(data);
                }
            }
        });
    });
