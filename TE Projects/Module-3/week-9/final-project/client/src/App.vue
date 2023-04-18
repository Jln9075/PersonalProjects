<template>
  <div id="app">
    <header>
      <img
        id="logo-image"
        src="https://via.placeholder.com/400x70/99eea8/aaaaaa?text=Your+Logo+here..."
        alt="logo goes here"
      />
    </header>
    <nav>
      <div id="left-navbar">
        <router-link id="home-button" to="/products">Home</router-link>
        <router-link to="/cart">Cart</router-link>
      </div>
      <div id="right-navbar">
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">Logout</router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
      </div>
    </nav>
    <main>
      <router-view />
    </main>
    <footer>&copy; 2022. All rights reserved.</footer>
  </div>
</template>

<style>

#app {
  height: 100%;
  display: grid;
  grid-template-rows: 80px 40px 1fr 25px;
  grid-template-areas:
    "header"
    "nav"
    "main"
    "footer";
}

a.router-link-exact-active {
  color: red;
}

header {
  grid-area: header;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #bbb;
  padding: 0 20px;
}

nav {
  padding: 0 10px;
  background-color: #bbb;
  border: 1px solid black;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

nav a {
  text-decoration: none;
  color:black;
}

#left-navbar {
  padding-left: 20px;
}

#home-button {
  padding-right: 20px;
}

#right-navbar {
  padding-right: 20px
}

main {
  grid-area: main;

}

footer {
  grid-area: footer;
}
</style>