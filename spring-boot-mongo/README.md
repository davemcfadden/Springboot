# Spring-Boot-Mongo
Spring-boot-mongo application.
When complete, the app will give a complete reference page for a number of Mongo shell commands
and their Java equivalent. All Java commands currently implemented have yet to be fully tested.

# Pre-requisites
- MongoDb3.0 or later installed
	- Create folder /data/db
	- Put Mongo bin directory onto your PATH variable.
	
- Import sample dataset, found under /src/main/resources/
	- This can be done by opening  command.exe and running
	```
	mongoimport --db sample --collection sampleset sample.json
	```

# Mongo Shell Commands to be included with Java equivalent

- Find (Select)
```
     db.sampleset.find()
     db.sampleset.find({"_id":"01011"})
     db.sampleset.find({"_id":{"$gt":"1000"})
     db.sampleset.find({"_id":{"$in":["01035","01033"}) 
     db.sampleset.find({"_id":"01035","city":"HADLEY"})
     db.sampleset.find({"_id":"01011"},{"_id":false},"city":true)
```

- Find (Distinct) - Returns an array of all of the distinct city keys

```
     db.sampleset.distinct("city")
```

- FindOne (Select first)

```
    db.sampleset.findOne()
    db.sampleset.findOne({"_id":"01011"})
```

- Update (overwrite)

```
   db.sampleset.update({"_id":"01011"},{"city":"london"})
```

- Updates

```
    db.sampleset.update({"_id":"01011"},{"$set":{"city":"london"}})
    db.sampleset.update({"city":"HADLEY"},{"$set":{"city":"london"}},{"multi":true})
    db.sampleset.update({"city":"HADLEY"},{"$set":{"city":"london"}},{"multi":true,"upsert":true})
```

- Inserts
```
    db.sampleset.insert({"_id":"11123","city":"belfast"})
```
    
- Delete
```
    db.sampleset.remove({"_id":"11123"})
    db.sampleset.remove()
```

# Future work

- Implement number of commands from the aggregation framework.
