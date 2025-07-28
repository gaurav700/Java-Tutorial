{ pkgs, ... }: {
  channel = "stable-24.05";

  packages = [
    pkgs.jdk21  # Install Java 21 (LTS)
  ];

  env = {
    JAVA_HOME = "${pkgs.jdk21}";
    # ❌ Do NOT set PATH manually here — it causes a build failure.
  };

  idx = {
    extensions = [
      "vscjava.vscode-java-pack"  # Java support in VS Code
    ];

    previews = {
      enable = true;
      previews = { };
    };

    workspace = {
      onCreate = {
        default.openFiles = [ ".idx/dev.nix" "README.md" ];
      };
      onStart = { };
    };
  };
}
