const int zero = 1, one = 2, point = 3, epsilon = 7;
int token = lexer();
void match(int t) 
{ 
    if (token == t) token = lexer();
    else error(); 
}
void S() {
    double bval, lval, rval, sval;
    switch (token) {
        case zero: 
        case one: 
        bval = L();
        match(point);
        rval = R();
        sval = lval + rval;

        break;
        default: error();
    }
    return sval;
}
double L() { 
    double bval, lsvalTemp, lsval;
    switch (token) {
        case zero: 
        case one: 
            bval = B();
            lsvalTemp = Ls(); 
            lsval = bval + lsvalTemp * 2;
        break;
        default: error();
    }
    return lsval;
}
double Ls() {
    double bval, lsvalTemp, lsval;
    switch (token) {
        case zero: 
        case one: 
            bval = B();
            lsvalTemp = Ls(); 
            lsval = bval + lsvalTemp * 2;
            break;
        case epsilon:
            lsval = 0;
            break;
        default: error();
    }
    return lsval;
}

double R() { 
    double bval, rsvalTemp, rsval;
    switch (token) {
        case zero: 
        case one: 
            bval = B();
            rsvalTemp = Rs(); 
            rsval = (bval + rsvalTemp) / 2;
        break;
        default: error();
    }
    return rsval;
}
double Rs() {
    double bval, rsvalTemp, rsval;
    switch (token) {
        case zero: 
        case one: 
            bval = B();
            rsvalTemp = Rs(); 
            rsval = (bval + rsvalTemp) / 2;
            break;
        case epsilon:
            rsval = 0;
            break;
        default: error();
    }
    return rsval;
}
double B() { 
    double bval;

    switch (token) {
        case zero:
            bval = 0;
            match(zero);
            break; 
        case one:     
            bval = 1;
            match(one);
        break;
        default: error();
    }
    return bval;
}