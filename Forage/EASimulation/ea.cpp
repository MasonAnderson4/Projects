#include <iostream>
using namespace std;

class Movement {
public:
    virtual void move() = 0;
};

class Stationary : public Movement {
public:
    void move() override {
        cout << "Player is stationary." << endl;
    }
};

class Running : public Movement {
public:
    void move() override {
        cout << "Player is running." << endl;
    }
};

class Walking : public Movement {
public:
    void move() override {
        cout << "Player is walking." << endl;
    }
};

class Hitting{
public:
    virtual void hit() = 0;
};

class HitStick : public Hitting {
public:
    void hit() override {
        cout << "Player did a hit stick." << endl;
    }
};

class Chop : public Hitting {
public:
    void hit() override {
        cout << "Player did a chop hit." << endl;
    }
};

class Wrap : public Hitting{
public:
    void hit() override {
        cout << "Player did a wrap tackle." << endl;
    }
};

class Action {
public:
    virtual void action() = 0;
};

class Truck : public Action {
public:
    void action() override {
        cout << "Player performed a truck." << endl;
    }
};

class Spin : public Action {
public:
    void action() override {
        cout << "Player perfomed a spin move." << endl;
    }
};

class Hurdle : public Action {
public:
    void action() override {
        cout << "Player performed a hurdle." << endl;
    }
};

class Player {
private:
   Movement* movement;
   Hitting* hitting;
   Action* action;
public:
    Player(Movement* m, Hitting* h, Action* a) : movement(m), hitting(h), action(a) {
    }
   
   void movementAction(){
    movement->move();
   }

   void hittingAction(){
    hitting->hit();
   }

   void acitonPerform(){
    action->action();
   }

};


