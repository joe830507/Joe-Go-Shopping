<template lang="">
  <div>
    <ul>
      <li v-for="(message, index) in messages" :key="index">
        {{ message }}
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  props: {
    messages: {
      type: Array,
    },
  },
  data() {
    return {};
  },
};
</script>
<style lang=""></style>
