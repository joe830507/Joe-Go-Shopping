import { shallowMount } from "@vue/test-utils";
import App from "../../src/App.vue";

describe("HelloWorld.vue", () => {
  it("renders props.msg when passed", () => {
    const wrapper = shallowMount(App);
    expect(wrapper.vm.messages[0]).toMatch("Cat");
    expect(wrapper.vm.messages.length).toBe(1);
  });
});
