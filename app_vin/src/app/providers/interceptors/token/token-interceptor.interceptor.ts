import {HttpInterceptorFn} from '@angular/common/http';

export const tokenInterceptorInterceptor: HttpInterceptorFn = (req, next) => {

    const token = localStorage.getItem('accessToken');
    if (token) {
        req = req.clone({
            setHeaders: {
                Authorization: `Bearer ${token}`,
            },
        });
        console.log(req.url);
        console.log(req.headers);
    }
    return next(req);
};
