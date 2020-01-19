#ifndef CAR_H
#define CAR_H
#include <string>
#include <iostream>
using namespace std;

class Car{
    private:
      unsigned int id;
      string model;
      string brand;
      double engineDisplacement;
    
    public:
      Car(){}
      Car( string MODEL, string BRAND, double ENGINEDISPLACEMENT)
      {
        setModel(MODEL);
        setBrand(BRAND);
        setEngineCapacity(ENGINEDISPLACEMENT);
      }
      Car(unsigned int ID, string MODEL, string BRAND, double ENGINEDISPLACEMENT)
      {
        setId(ID);
        setModel(MODEL);
        setBrand(BRAND);
        setEngineCapacity(ENGINEDISPLACEMENT);
      }

    // Getters and setters
    public:
      void setId(unsigned int ID)
      {
        id = ID;
      }
      void setModel(string MODEL) {
        model = MODEL;

      }
      void setBrand(string BRAND)
      {
        brand = BRAND;
      }
      void setEngineCapacity(double DISPLACEMENT)
      {
        engineCapacity = DISPLACEMENT;
      }
      unsigned int getId() 
      {
        return id;
      }
      string getModel()
      {
        return model;
      }
      string getBrand()
      {
        return brand;
      }
      double getEngineDisplacement()
      {
        return engineDisplacement;
      }
    
};

#endif // CAR_H