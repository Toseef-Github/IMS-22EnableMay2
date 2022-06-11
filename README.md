Coverage: 

Inventory Management System

This system allows you to create, read, update and delete customers, items and orders. The previous functions listed are able to be carried out via a command line interface. During this project, Java, Eclipse, Agile, MySQL, Maven, Junit and Github were all utilised to ensure a structured approach.

## Getting Started

In order to use this system, you must first create a local repository on your device and clone this remote repository to the local one. Once done, you should have all the files needed to be able to use the system.

### Prerequisites

GitBash – To clone the remote repository to your local repository.
https://git-scm.com/downloads

Java (Eclipse) – Eclipse is required to open the java files and access the CLI as well as to carry out testing.
https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers
 
MySQL – To create a database which will be linked and updated through the CLI in eclipse.
https://www.mysql.com/downloads/

Maven/Junit/Mockito – Are used for testing through eclipse.
https://maven.apache.org/download.cgi 

### Installing

1. Once you have cloned the repository to your local device, open eclipse on your device and select;
"File: > "Open projects from file system" > select the folder cloned "IMS-22EnableMay2".

This should open the project in Eclipse.

2. To be able to interact with the project and use its functions you must run the correct class.
To do this navigate to the runner class which can be found: 
"src" > "main" > "java" > "com" > "qa" > "ims" > "runner"

3. Double click runner to open the class. 

4. Right click within the class and select "run as" > "Java application". 

5. You should now see your console showing the command line interface. The interface will show you your options (Customer, Item, Order and OrderItems).

6. Enter the table name decried and follow the instructions on the interface to use the CRUD functionalities.


EXAMPLE:

Type the following into the CLI -

"Customer" (press enter)
"Create" (press enter)
"Thomas" (press enter)
"Tuchel" (press enter) 

The CLI should inform you that a customer has been created

"Read" (press enter)

The CLI should show the customer "Thomas Tuchel" created as well as its unique auto-incremented customer ID number.


## Running the tests

To run an automated test of the whole project and check the coverage, follow the steps below;

1. Right click on the project folder ("IMS-22EnableMay2") on the left in Eclipse

2. Go to "coverage as" > "JUnit test" 

3. Once JUnit tests run you should see the tests on the left as well as a breakdown showing coverage of each folder/file in the console.

### Unit Tests 

The unit tests purpose is to test sections of the code individually to see if they run without errors.

Please see an example of a unit test below:

	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "car", 10000);
		assertEquals(updated, DAO.update(updated));

	}


### Integration Tests 
The integration tests purpose is to test how everything works together. 

Please see an example of a unit test below:

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "ball", 10);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getPrice());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}


## Deployment

To deploy the project, you run the "its-0.0.1-jar-with-dependencies.jar" file which can be found inside the "IMS-22EnableMay2" folder.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Thank you to all the QA trainers who helped me during the first 5 weeks of training, especially Jordan!
