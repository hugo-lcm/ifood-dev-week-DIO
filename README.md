<h1>Bag API</h1>
<p>Bag API to serve a delivery application</p>

<h3>Features</h3>

- [x] Include items in the bag<br>
- [x] View bag<br>
- [x] Close bag<br>

<h3>Application Demo</h3>
<p>Before starting, you need to have the following tools installed on your machine:</p>
<table>
<tr>
	<th>Tool</th>
	<th>Version</th>
</tr>
<tr>
	<td>Java JDK</td>
	<td>8+</td>
</tr>
<tr>
	<td>Git</td>
	<td>2.**</td>
</tr>
<tr>
	<td>Gradle</td>
	<td>7.**</td>
</tr>
<tr>
	<td>Postman</td>
	<td>9.**</td>
</tr>
</table>
<h6>** In order to facilitate the demonstration of the application, I recommend installing IntelliJ IDEA and running the project through the IDE **</h6>

In Terminal/Console:
<ol>
	<li>Make a clone of the project on your machine: <code>git clone https://github.com/hugo-lcm/ifood-dev-week-DIO.git</code></li>
	<li>Enter the project root folder: <code>cd bag-api</code></li> 
	<li>Run the command: <code>./gradlew bootrun</code></li>
	<li>With the application running, click here: <a href="http://localhost:8081/swagger-ui/">http://localhost:8081/swagger-ui/</a></li>
</ol>

<a href="https://drive.google.com/file/d/1-FTY7jRfYbqVNQi-B7Dvn8p6wjnzf2f6/view?usp=sharing"> 🚀 Collection Sacola API - Postman</a><br>

<img src="https://user-images.githubusercontent.com/74077027/193702261-4eefe2d7-e92d-4be8-ad5d-11b3a25c6fd0.png" alt="Bag API Swagger UI">

<h3>Technologies Used</h3>

<table>
<tr>
	<th>Dependency</th>
	<th>Version</th>
</tr>
<tr>
	<td>spring initialzr</td>
	<td><a href="https://start.spring.io/">https://start.spring.io/</a></td>
</tr>
<tr>
	<td>spring-boot-starter-web</td>
	<td>2.7.4</td>
</tr>
<tr>
	<td>spring-boot-starter-data-jpa</td>
	<td>2.7.4</td>
</tr>
<tr>
	<td>lombok</td>
	<td>1.18.24</td>
</tr>
<tr>
	<td>springfox-boot-starter</td>
	<td>3.0.0</td>
</tr>
<tr>
	<td>h2</td>
	<td>2.1.214</td>
</tr>
</table>
