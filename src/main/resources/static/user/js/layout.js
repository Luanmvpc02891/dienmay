var app = angular.module("myapp", ["ngRoute"]);
app.run(function ($rootScope) {
    $rootScope.$on('$routeChangeStart', function () {
        $rootScope.loading = true;
    });
    $rootScope.$on('$routeChangeSuccess', function () {
        $rootScope.loading = false;
    });
    $rootScope.$on('$routeChangeError', function () {
        $rootScope.loading = false;
        alert("Lỗi");
    });
});
app.config(function ($routeProvider) {
    $routeProvider
        .when('/index', {
            templateUrl: '/src/main/resources/templates/user/view/index.html',
            controller: 'indexctrl'
        }).when('/shop', {
            templateUrl: '/src/main/resources/templates/user/view/shop-gird.html',
            controller: 'shopctrl'
        })
        .otherwise({
            redirectTo: '/index'
        });

});