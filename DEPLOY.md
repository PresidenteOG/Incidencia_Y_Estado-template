# Deploying incident-tracker

The app is a single self-contained Spring Boot jar on in-memory H2. There is no database to
provision and no secret to set — it re-seeds itself on every start. That makes it a good fit
for any free container host.

## What's in the repo for this

- **`Dockerfile`** — two-stage build (Maven → JRE). `docker build -t incident-tracker . && docker run -p 8080:8080 incident-tracker` works as-is.
- **`render.yaml`** — a Render blueprint: one free Docker web service, health check on `/LoginIncidencia`.
- `server.port=${PORT:8080}` in `application.properties` — picks up the port Render / Railway / Fly injects.

## Render (matches `render.yaml`)

1. Sign in at <https://render.com> with the GitHub account.
2. **New → Blueprint**, pick `PresidenteOG/incident-tracker`. Render reads `render.yaml`.
3. **Apply**. First build is ~3–4 min.
4. The URL is `https://incident-tracker-XXXX.onrender.com`. Log in with `admin` / `admin`.

Free instances sleep after 15 min idle; the next hit takes ~30 s to wake. Fine for a portfolio
link — say so next to it.

## Railway / Fly (alternative)

- **Railway:** New Project → Deploy from GitHub repo → it detects the `Dockerfile`. No config.
- **Fly:** `fly launch --dockerfile Dockerfile` then `fly deploy`. Set `internal_port = 8080` in `fly.toml`.

## After it's live

Put the URL in this README's header and in the profile README's project list, with the
cold-start note.
