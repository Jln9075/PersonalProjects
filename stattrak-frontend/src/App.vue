<template>
  <div id="app">
    <header class="fullWidth">
      <router-link to="/" class="title">LeagueStatTracker</router-link>
    </header>
    <main>
      <router-view />
    </main>

    <footer>© James Nelson 2023</footer>
  </div>
</template>

<script>
export default {
  name: "App",

  components: {},
};
</script>

<style>
h1 {
  margin: 0px;
}

header {
  color: black;
  background-color: #92a8d1;
  text-align: center;
}

.fullWidth {
  width: 100vw;
}

#app {
  display: grid;
  grid-row: 50px, 1fr, 1em;
}

body {
  margin: 0;
  padding: 0;
}

html {
  height: 100%;
  background-image: linear-gradient(#92a8d1, #ffffff);
}
footer {
  position: fixed;
  bottom: 0;
}
</style>
