module.exports = {
  presets: [
    [
      '@babel/preset-env',
      {
        targets: {
          node: '16.19.0',
        },
      },
    ],
    '@babel/preset-typescript',
  ],
  plugins: [
    [
      'module-resolver',
      {
        alias: {
          '@routes': './src/routes',
          '@models': './src/database/models',
        },
      },
    ],
  ],
};
