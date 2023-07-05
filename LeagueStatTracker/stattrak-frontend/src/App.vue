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
a:active,
a:hover,
a:visited,
a:link {
  text-decoration: none;
  color: rgb(218, 241, 7);
  font-size: 5em;
}

header {
  background-color: #082a6e;
  text-align: center;
  margin-bottom: 3%;
}

h1 {
  margin: 0px;
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
  background-image: linear-gradient(#001c53, #aaaff3);
}
footer {
  position: fixed;
  bottom: 0;
}
</style>
