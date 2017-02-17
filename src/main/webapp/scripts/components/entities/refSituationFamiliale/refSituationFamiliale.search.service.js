'use strict';

angular.module('creamApp')
    .factory('RefSituationFamilialeSearch', function ($resource) {
        return $resource('api/_search/refSituationFamiliales/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
