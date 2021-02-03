import json
from urllib import request as req

print("Showing Java RESTful Web Service Information")

try:
    no=int(input("Enter celebrity number : "))
    response=req.urlopen('http://localhost:8080/CelebrityProject/api/celeb/'+str(no))
    resdata=response.read()
    info=json.loads(resdata)
    print(info)
    print('-'*30)
    print("Name : "+str(info["celebnm"]))
    print("Field : "+str(info["field"]))
    print("Country : "+str(info["country"]))
except:
    print("Error reading REST data")
