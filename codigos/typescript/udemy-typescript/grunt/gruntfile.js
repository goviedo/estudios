module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-ts');

  grunt.initConfig({
    ts: {
      main: {
        src: ['typescript/*.ts'],
        out: 'javascript/main.js'
      }
    }
  })

  grunt.registerTask('default',['ts']);
}
